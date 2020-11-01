package com.telepathicgrunt.repurposedstructures;

import com.telepathicgrunt.repurposedstructures.configs.RSAllConfig;
import com.telepathicgrunt.repurposedstructures.misc.VillagerTrades;
import com.telepathicgrunt.repurposedstructures.modinit.RSConfiguredFeatures;
import com.telepathicgrunt.repurposedstructures.modinit.RSConfiguredStructures;
import com.telepathicgrunt.repurposedstructures.modinit.RSFeatures;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructures;
import com.telepathicgrunt.repurposedstructures.utils.MobSpawnerManager;
import com.telepathicgrunt.repurposedstructures.modinit.RSPlacements;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("deprecation")
public class RepurposedStructures implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "repurposed_structures";
    public static MobSpawnerManager mobSpawnerManager = null;
    public static boolean yungsBetterMineshaftIsNotOn = true;

	public static RSAllConfig RSAllConfig = null;
    public static final Map<String, List<String>> ALL_BIOME_BLACKLISTS = new HashMap<>();

    //TODO: make zombie badlands village
    //TODO NEXT: overworld biome specific outposts

    @Override
    public void onInitialize() {
        // LoadNbtBlock.instantiateNbtBlock();
        RSAddFeaturesAndStructures.allowStructureSpawningPerDimension();
        RSAddFeaturesAndStructures.setupBiomeModifications();
    }

    public static void initialize() {
        AutoConfig.register(RSAllConfig.class, Toml4jConfigSerializer::new);
        RSAllConfig = AutoConfig.getConfigHolder(RSAllConfig.class).getConfig();

        ServerStartCallback.EVENT.register(minecraftServer -> VillagerTrades.addMapTrades());

        RSPlacements.registerPlacements();
        RSFeatures.registerFeatures();
        RSStructures.registerStructures();
        RSConfiguredFeatures.registerConfiguredFeatures();
        RSConfiguredStructures.registerConfiguredStructures();

        yungsBetterMineshaftIsNotOn = !FabricLoader.INSTANCE.isModLoaded("bettermineshafts");
    }

    /**
     * Grabs and parses the Biome blacklist from configs and stores it into
     * a map of structure/feature type to their specific blacklist.
     *
     * The structure/feature types are:
     *
     * "dungeon", "boulder", "swamp_tree", "fortress", "igloo",
     * "mineshaft", "outpost", "shipwreck", "stronghold", "temple",
     * "pyramid", "village", "well"
     *
     * @return - A map of structure/feature type to their biome blacklist
     */
    public static Map<String, List<String>> getBiomeBlacklists(){

        ALL_BIOME_BLACKLISTS.put("dungeon", Arrays.asList(RepurposedStructures.RSAllConfig.RSDungeonsConfig.blacklistedDungeonBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("boulder", Arrays.asList(RepurposedStructures.RSAllConfig.RSMainConfig.misc.blacklistedBoulderBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("swamp_tree", Arrays.asList(RepurposedStructures.RSAllConfig.RSMainConfig.misc.blacklistedSwampTreeBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("fortress", Arrays.asList(RepurposedStructures.RSAllConfig.RSMainConfig.jungleFortress.blacklistedFortressBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("igloo", Arrays.asList(RepurposedStructures.RSAllConfig.RSMainConfig.igloos.blacklistedIglooBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("mineshaft", Arrays.asList(RepurposedStructures.RSAllConfig.RSMineshaftsConfig.blacklistedMineshaftBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("outpost", Arrays.asList(RepurposedStructures.RSAllConfig.RSOutpostsConfig.blacklistedOutpostBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("shipwreck", Arrays.asList(RepurposedStructures.RSAllConfig.RSShipwrecksConfig.blacklist.blacklistedShipwreckBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("stronghold", Arrays.asList(RepurposedStructures.RSAllConfig.RSStrongholdsConfig.blacklistedStrongholdBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("temple", Arrays.asList(RepurposedStructures.RSAllConfig.RSTemplesConfig.temples.blacklistedTempleBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("pyramid", Arrays.asList(RepurposedStructures.RSAllConfig.RSTemplesConfig.pyramids.blacklistedPyramidBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("village", Arrays.asList(RepurposedStructures.RSAllConfig.RSVillagesConfig.blacklistedVillageBiomes.split(",")));
        ALL_BIOME_BLACKLISTS.put("well", Arrays.asList(RepurposedStructures.RSAllConfig.RSWellsConfig.blacklistedWellBiomes.split(",")));

        return ALL_BIOME_BLACKLISTS;
    }
}
