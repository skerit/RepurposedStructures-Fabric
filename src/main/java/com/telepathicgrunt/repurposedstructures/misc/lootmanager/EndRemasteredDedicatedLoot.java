package com.telepathicgrunt.repurposedstructures.misc.lootmanager;

import com.telepathicgrunt.repurposedstructures.RepurposedStructuresApi;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndRemasteredDedicatedLoot {
    private EndRemasteredDedicatedLoot() {}

    public static boolean isEndRemasteredOn = false;
    private static final Map<ResourceLocation, ResourceLocation> END_REMASTERED_DEDICATED_TABLE_IMPORTS = createEndRemasteredMap();
    private static Map<ResourceLocation, ResourceLocation> createEndRemasteredMap() {
        Map<ResourceLocation, ResourceLocation> tableMap = new HashMap<>();
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/birch"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/ocean"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/savanna"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/stone"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/swamp"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/dark_forest"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/taiga"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/igloos/stone"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/badlands"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/dark_forest"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/deep"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/desert"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/jungle"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/icy"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/mushroom"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/ocean"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/snow"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/swamp"), new ResourceLocation("endrem:minecraft/chests/simple_dungeon"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/fortresses/jungle_shrine"), new ResourceLocation("endrem:minecraft/chests/jungle_temple"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/jungle"), new ResourceLocation("endrem:minecraft/chests/jungle_temple"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/jungle"), new ResourceLocation("endrem:minecraft/chests/jungle_temple"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/flower_forest"), new ResourceLocation("endrem:minecraft/chests/jungle_temple"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/igloos/mushroom"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/igloos/grassy"), new ResourceLocation("endrem:minecraft/chests/abandoned_mineshaft"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/desert"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/mushroom"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/giant_tree_taiga"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/dark_forest"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "trapped_chests/pyramids/badlands"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "trapped_chests/pyramids/ocean"), new ResourceLocation("endrem:minecraft/chests/desert_pyramid"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/icy"), new ResourceLocation("endrem:minecraft/chests/igloo_chest"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/snowy"), new ResourceLocation("endrem:minecraft/chests/igloo_chest"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/pyramids/icy"), new ResourceLocation("endrem:minecraft/chests/igloo_chest"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/badlands"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/birch"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/desert"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/giant_tree_taiga"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/icy"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/jungle"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/oak"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/snowy"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/taiga"), new ResourceLocation("endrem:minecraft/chests/pillager_outpost"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/crimson"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/nether_brick"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/outposts/warped"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/dungeons/nether"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/crimson"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/nether"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/mineshafts/warped"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/temples/basalt"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/temples/crimson"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/temples/soul"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/temples/wasteland"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/temples/warped"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "trapped_chests/temples/warped"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "trapped_chests/pyramids/nether"), new ResourceLocation("endrem:minecraft/chests/nether_bridge"));

        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/shipwrecks/crimson/treasure"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/shipwrecks/nether_bricks/treasure"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/shipwrecks/warped/treasure"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/bastions/underground/treasure"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/bastions/underground/bridge"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));
        tableMap.put(new ResourceLocation(RepurposedStructuresApi.MODID, "chests/bastions/underground/skeleton_horse_stable"), new ResourceLocation("endrem:minecraft/chests/buried_treasure"));

        return tableMap;
    }

    protected static void handleDedicatedModCompat(List<ItemStack> currentLoot, ResourceLocation lootTableID, LootContext oldLootContext){
        // Remove their eyes from the default importing and instead, import the correct eyes they really want for this structure.
        if(isEndRemasteredOn) {
            // Remove incorrect End Remastered loot
            currentLoot.removeIf(itemStack -> Registry.ITEM.getKey(itemStack.getItem()).getNamespace().equals("endrem"));

            // Get correct pool they want us to use
            ResourceLocation tableToImportLoot = END_REMASTERED_DEDICATED_TABLE_IMPORTS.get(lootTableID);
            if(tableToImportLoot == null) return; // No entry found

            // Generate End Remastered's dedicated loot
            LootContext newContext = StructureModdedLootImporter.copyLootContext(oldLootContext);
            List<ItemStack> endRemasteredLoot = oldLootContext.getLootTable(tableToImportLoot).getRandomItems(newContext);

            currentLoot.addAll(endRemasteredLoot);
        }
    }
}
