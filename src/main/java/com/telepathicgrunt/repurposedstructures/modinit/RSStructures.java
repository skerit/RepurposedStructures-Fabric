package com.telepathicgrunt.repurposedstructures.modinit;

import com.telepathicgrunt.repurposedstructures.RepurposedStructuresApi;
import com.telepathicgrunt.repurposedstructures.world.structures.CityNetherStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.GenericJigsawStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.GenericNetherJigsawStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.MansionStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.MineshaftEndStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.MineshaftStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.MonumentStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.ShipwreckNetherStructure;
import com.telepathicgrunt.repurposedstructures.world.structures.StrongholdEndStructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureType;


public final class RSStructures {
    private RSStructures() {}

    public static StructureType<GenericJigsawStructure> GENERIC_JIGSAW_STRUCTURE = () -> GenericJigsawStructure.CODEC;
    public static StructureType<MansionStructure> MANSION_STRUCTURE = () -> MansionStructure.CODEC;
    public static StructureType<MonumentStructure> MONUMENT_STRUCTURE = () -> MonumentStructure.CODEC;
    public static StructureType<MineshaftStructure> GENERIC_MINESHAFT = () -> MineshaftStructure.CODEC;
    public static StructureType<MineshaftEndStructure> MINESHAFT_END = () -> MineshaftEndStructure.CODEC;
    public static StructureType<StrongholdEndStructure> STRONGHOLD_END = () -> StrongholdEndStructure.CODEC;
    public static StructureType<ShipwreckNetherStructure> SHIPWRECK_NETHER_STRUCTURE = () -> ShipwreckNetherStructure.CODEC;
    public static StructureType<CityNetherStructure> CITY_NETHER_STRUCTURE = () -> CityNetherStructure.CODEC;
    public static StructureType<GenericNetherJigsawStructure> GENERIC_NETHER_JIGSAW_STRUCTURE = () -> GenericNetherJigsawStructure.CODEC;


    public static void registerStructures() {
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "generic_jigsaw_structure"), GENERIC_JIGSAW_STRUCTURE);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "mansion_structure"), MANSION_STRUCTURE);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "monument_structure"), MONUMENT_STRUCTURE);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "generic_mineshaft"), GENERIC_MINESHAFT);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "mineshaft_end"), MINESHAFT_END);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "stronghold_end"), STRONGHOLD_END);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "shipwreck_nether_structure"), SHIPWRECK_NETHER_STRUCTURE);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "city_nether_structure"), CITY_NETHER_STRUCTURE);
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(RepurposedStructuresApi.MODID, "generic_nether_jigsaw_structure"), GENERIC_NETHER_JIGSAW_STRUCTURE);

        //registers the structure pieces.
        RSStructurePieces.registerStructurePieces();
    }
}
