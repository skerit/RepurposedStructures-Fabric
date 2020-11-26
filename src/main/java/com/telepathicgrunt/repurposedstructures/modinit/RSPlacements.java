package com.telepathicgrunt.repurposedstructures.modinit;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.world.placements.RSDungeonPlacement;
import com.telepathicgrunt.repurposedstructures.world.placements.RSVinePlacement;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountDecorator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.decorator.SimpleDecorator;

public class RSPlacements
{
    public static final SimpleDecorator<RangeDecoratorConfig> RS_DUNGEON_PLACEMENT = new RSDungeonPlacement(RangeDecoratorConfig.CODEC);
    public static final Decorator<RangeDecoratorConfig> RS_VINE_PLACEMENT = new RSVinePlacement(RangeDecoratorConfig.CODEC);
    public static final Decorator<CountConfig> RS_UNLIMITED_COUNT = new CountDecorator(UniformIntDistribution.CODEC.fieldOf("count").xmap(CountConfig::new, CountConfig::getCount).codec());

    public static void registerPlacements() {
        Registry.register(Registry.DECORATOR, RepurposedStructures.MODID+":rs_dungeon_placement", RS_DUNGEON_PLACEMENT);
        Registry.register(Registry.DECORATOR, RepurposedStructures.MODID+":rs_vine_placement", RS_VINE_PLACEMENT);
        Registry.register(Registry.DECORATOR, RepurposedStructures.MODID+":rs_unlimited_count", RS_UNLIMITED_COUNT);
    }
}
