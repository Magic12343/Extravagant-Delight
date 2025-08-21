package net.magicvt.extravagantdelight.compat.food;

import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;

public class NTCombatFoodValues extends FoodValues {


    public static final FoodProperties STRAWBERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
            .build();
    public static final FoodProperties STRAWBERRY_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 200, 1), 1.0F)
            .build();
    public static final FoodProperties MINT_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 200, 1), 1.0F)
            .build();




}
