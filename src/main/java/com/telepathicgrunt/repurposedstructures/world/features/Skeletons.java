package com.telepathicgrunt.repurposedstructures.world.features;

import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import com.telepathicgrunt.repurposedstructures.world.features.configs.GenericMobConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;


public class Skeletons extends Feature<GenericMobConfig> {

    public Skeletons() {
        super(GenericMobConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos position, GenericMobConfig config) {

        SkeletonEntity skeletonEntity = EntityType.SKELETON.create(world.toServerWorld());

        // Do this first as this attaches a bow automatically. We may want to override the bow later.
        skeletonEntity.initialize(world, world.getLocalDifficulty(position), SpawnReason.STRUCTURE, null, null);

        if(config.heldItem != null){
            ItemStack heldItem = new ItemStack(config.heldItem);
            skeletonEntity.setStackInHand(Hand.MAIN_HAND, GeneralUtils.enchantRandomly(random, heldItem, 0.333F));
            skeletonEntity.setLeftHanded(random.nextFloat() < 0.05F);
        }

        if(config.helmet != null){
            skeletonEntity.equipStack(EquipmentSlot.HEAD, GeneralUtils.enchantRandomly(random, config.helmet.getDefaultStack(), 0.075F));
        }
        if(config.chestplate != null){
            skeletonEntity.equipStack(EquipmentSlot.CHEST, GeneralUtils.enchantRandomly(random, config.chestplate.getDefaultStack(), 0.075F));
        }
        if(config.leggings != null){
            skeletonEntity.equipStack(EquipmentSlot.LEGS, GeneralUtils.enchantRandomly(random, config.leggings.getDefaultStack(), 0.075F));
        }
        if(config.boots != null){
            skeletonEntity.equipStack(EquipmentSlot.FEET, GeneralUtils.enchantRandomly(random, config.boots.getDefaultStack(), 0.075F));
        }

        skeletonEntity.setPersistent();
        skeletonEntity.refreshPositionAndAngles(
                (double)position.getX() + 0.5D,
                position.getY(),
                (double)position.getZ() + 0.5D,
                0.0F,
                0.0F);

        skeletonEntity.setHealth(config.health);
        skeletonEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(config.speedModifier);
        world.spawnEntityAndPassengers(skeletonEntity);
        return true;
    }

}