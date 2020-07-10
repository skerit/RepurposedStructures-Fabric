package com.telepathicgrunt.repurposedstructures.configs;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;


@Config(name = "Repurposed_Structures-Temples")
public class RSTempleConfig implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    public Temples temples = new Temples();

    @ConfigEntry.Gui.CollapsibleObject
    public Pyramids pyramids = new Pyramids();

    public static class Temples {

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Temples in Nether Wastelands."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherWastelandTempleSpawnrate = 26;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("Add Nether Wasteland Temples to modded Nether biomes that other nether temples don't fit in.")
        public boolean addNetherWastelandTempleToModdedBiomes = false;


        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Basalt Temples in Nether Basalt Delta biomes."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherBasaltTempleSpawnrate = 26;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Nether Basalt Temples to modded Nether Basalt biomes.")
        public boolean addNetherBasaltTempleToModdedBiomes = false;


        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Crimson Temples in Nether Crimson Forest."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherCrimsonTempleSpawnrate = 26;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Nether Crimson Temples to modded Nether Crimson Forest biomes.")
        public boolean addNetherCrimsonTempleToModdedBiomes = false;


        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Crimson Temples in Nether Warped Forest."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherWarpedTempleSpawnrate = 26;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Nether Warped Temples to modded Nether Warped Forest biomes.")
        public boolean addNetherWarpedTempleToModdedBiomes = false;


        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Soul Temples in Nether Soul Sand Valley."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherSoulTempleSpawnrate = 26;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Nether Soul Temples to modded Nether Soul Sand Valley biomes.")
        public boolean addNetherSoulTempleToModdedBiomes = false;
    }


    public static class Pyramids {

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Pyramids in Nether."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int netherPyramidSpawnrate = 32;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Nether Pyramids to modded Nether biomes.")
        public boolean addNetherPyramidToModdedBiomes = false;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("How rare are Nether Temples in Nether."
                + "\n1 for spawning in most chunks and 1001 for none.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1001)
        public int badlandsTempleSpawnrate = 20;

        @ConfigEntry.Gui.Tooltip
        @Comment("Controls whether loot chests spawn or not in Badlands Temples.")
        public boolean lootChestsBT = true;

        @ConfigEntry.Gui.Tooltip
        @Comment("Add Badlands Temple to modded Badlands biomes.")
        public boolean addBadlandsTempleToModdedBiomes = false;

    }
}
