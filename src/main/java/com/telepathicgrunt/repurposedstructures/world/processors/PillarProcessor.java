package com.telepathicgrunt.repurposedstructures.world.processors;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.telepathicgrunt.repurposedstructures.modinit.RSProcessors;
import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Map;
import java.util.stream.Collectors;

public class PillarProcessor extends StructureProcessor {

    public static final Codec<PillarProcessor> CODEC  = RecordCodecBuilder.create((instance) -> instance.group(
            RegistryLookupCodec.create(Registry.PROCESSOR_LIST_REGISTRY)
                    .forGetter((processor) -> processor.processorListRegistry),
            Codec.mapPair(BlockState.CODEC.fieldOf("trigger"), BlockState.CODEC.fieldOf("replacement"))
                    .codec().listOf()
                    .xmap((list) -> list.stream().collect(Collectors.toMap(Pair::getFirst, Pair::getSecond)),
                            (map) -> map.entrySet().stream().map((entry) -> Pair.of(entry.getKey(), entry.getValue())).collect(Collectors.toList()))
                    .fieldOf("pillar_trigger_and_replacements")
                    .forGetter((processor) -> processor.pillarTriggerAndReplacementBlocks),
            ResourceLocation.CODEC
                    .optionalFieldOf("pillar_processor_list", null)
                    .forGetter(processor -> processor.processorList),
            Direction.CODEC
                    .optionalFieldOf("direction", Direction.DOWN)
                    .forGetter(processor -> processor.direction),
            Codec.intRange(0, 1)
                    .optionalFieldOf("pillar_length", 1000)
                    .forGetter(config -> config.pillarLength))
    .apply(instance, instance.stable(PillarProcessor::new)));

    public final Registry<StructureProcessorList> processorListRegistry;
    public final Map<BlockState, BlockState> pillarTriggerAndReplacementBlocks;
    public final ResourceLocation processorList;
    public final Direction direction;
    public final int pillarLength;

    private PillarProcessor(Registry<StructureProcessorList> processorListRegistry,
                            Map<BlockState, BlockState> pillarTriggerAndReplacementBlocks,
                            ResourceLocation processorList,
                            Direction direction,
                            int pillarLength)
    {
        this.processorListRegistry = processorListRegistry;
        this.pillarTriggerAndReplacementBlocks = pillarTriggerAndReplacementBlocks;
        this.processorList = processorList;
        this.direction = direction;
        this.pillarLength = pillarLength;
    }

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos templateOffset, BlockPos worldOffset, StructureTemplate.StructureBlockInfo structureBlockInfoLocal, StructureTemplate.StructureBlockInfo structureBlockInfoWorld, StructurePlaceSettings structurePlacementData) {

        BlockState blockState = structureBlockInfoWorld.state;
        if (pillarTriggerAndReplacementBlocks.containsKey(blockState)) {
            BlockPos worldPos = structureBlockInfoWorld.pos;

            BlockState replacementState = pillarTriggerAndReplacementBlocks.get(blockState);
            BlockState currentBlock = levelReader.getBlockState(worldPos);
            BlockPos.MutableBlockPos currentPos = new BlockPos.MutableBlockPos().set(worldPos);
            StructureProcessorList structureProcessorList = null;
            if(processorList != null) {
                structureProcessorList = processorListRegistry.get(processorList);
            }

            if(levelReader instanceof WorldGenRegion worldGenRegion && !worldGenRegion.getCenter().equals(new ChunkPos(currentPos))) {
                return replacementState == null || replacementState.is(Blocks.STRUCTURE_VOID) ? null : new StructureTemplate.StructureBlockInfo(worldPos, replacementState, null);
            }

            int terrainY = Integer.MIN_VALUE;
            if(direction == Direction.DOWN) {
                terrainY = GeneralUtils.getFirstLandYFromPos(levelReader, worldPos);
                if(terrainY <= levelReader.getMinBuildHeight() && pillarLength + 2 >= worldPos.getY() - levelReader.getMinBuildHeight()) {
                    // Replaces the data block itself
                    return (replacementState == null || replacementState.is(Blocks.STRUCTURE_VOID)) ?
                            null : new StructureTemplate.StructureBlockInfo(worldPos, replacementState, null);
                }
            }

            // Creates the pillars in the world that replaces air and liquids
            while(!currentBlock.canOcclude() &&
                currentPos.getY() <= levelReader.dimensionType().logicalHeight() &&
                currentPos.getY() >= terrainY &&
                currentPos.closerThan(worldPos, pillarLength)
            ) {
                StructureTemplate.StructureBlockInfo newPillarState1 = new StructureTemplate.StructureBlockInfo(currentPos.subtract(worldPos).offset(templateOffset), replacementState, null);
                StructureTemplate.StructureBlockInfo newPillarState2 = new StructureTemplate.StructureBlockInfo(currentPos.immutable(), replacementState, null);

                if(structureProcessorList != null) {
                    for(StructureProcessor processor : structureProcessorList.list()) {
                        if(newPillarState2 == null) {
                            break;
                        }
                        newPillarState2 = processor.processBlock(levelReader, newPillarState1.pos, newPillarState2.pos, newPillarState1, newPillarState2, structurePlacementData);
                    }
                }

                if(newPillarState2 != null) {
                    levelReader.getChunk(currentPos).setBlockState(currentPos, newPillarState2.state, false);
                }

                currentPos.move(direction);
                currentBlock = levelReader.getBlockState(currentPos);
            }

            // Replaces the data block itself
            return (replacementState == null || replacementState.is(Blocks.STRUCTURE_VOID)) ?
                    null : new StructureTemplate.StructureBlockInfo(worldPos, replacementState, null);
        }

        return structureBlockInfoWorld;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return RSProcessors.PILLAR_PROCESSOR;
    }
}
