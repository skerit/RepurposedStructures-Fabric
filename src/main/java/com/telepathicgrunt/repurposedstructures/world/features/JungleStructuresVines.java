package com.telepathicgrunt.repurposedstructures.world.features;

import com.google.common.collect.Sets;
import com.telepathicgrunt.repurposedstructures.modinit.RSFeatures;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructures;
import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.Set;


public class JungleStructuresVines extends Feature<DefaultFeatureConfig> {

    public JungleStructuresVines() {
        super(DefaultFeatureConfig.CODEC);
    }

    Set<Block> FORTRESS_BLOCKS_SET = Sets.newHashSet(
            Blocks.STONE_BRICKS,
            Blocks.CHISELED_STONE_BRICKS,
            Blocks.CRACKED_STONE_BRICKS,
            Blocks.MOSSY_STONE_BRICKS,
            Blocks.INFESTED_CHISELED_STONE_BRICKS,
            Blocks.INFESTED_CRACKED_STONE_BRICKS,
            Blocks.INFESTED_MOSSY_STONE_BRICKS,
            Blocks.INFESTED_STONE_BRICKS,
            Blocks.IRON_BARS,
            Blocks.STONE);

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos position, DefaultFeatureConfig config) {
        if(GeneralUtils.isWorldBlacklisted(world)) return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(position);
        //Place vines without replacing blocks.
        if (world.isAir(mutable)) {
            if(world.getStructures(ChunkSectionPos.from(mutable), RSStructures.JUNGLE_VILLAGE).findAny().isPresent() ||
                    world.getStructures(ChunkSectionPos.from(mutable), RSStructures.JUNGLE_FORTRESS).findAny().isPresent())
            {
                RSFeatures.SHORT_VINES.generate(world, chunkGenerator, random, mutable, DefaultFeatureConfig.DEFAULT);
                return true;
            }
        }

        //Place vines and can replace Stone Bricks if it has air below.
        if (FORTRESS_BLOCKS_SET.contains(world.getBlockState(mutable).getBlock()) && world.isAir(mutable.move(Direction.DOWN))) {
            if (world.getStructures(ChunkSectionPos.from(mutable.move(Direction.UP)), RSStructures.JUNGLE_FORTRESS).findAny().isPresent()) {
                world.setBlockState(mutable, Blocks.AIR.getDefaultState(), 3);
                RSFeatures.SHORT_VINES.generate(world, chunkGenerator, random, mutable, DefaultFeatureConfig.DEFAULT);

                //make sure we dont cause floating vine by scheduling a tick update so vine breaks itself
                for(Direction facing : Direction.Type.HORIZONTAL){
                    mutable.set(position).move(facing);
                    BlockState state = world.getBlockState(mutable);

                    // no floating vines
                    while(state.getMaterial() == Material.REPLACEABLE_PLANT){
                        world.setBlockState(mutable, Blocks.AIR.getDefaultState(), 3);
                        state = world.getBlockState(mutable.move(Direction.DOWN));
                    }
                }

                return true;
            }
        }

        return false;
    }
}