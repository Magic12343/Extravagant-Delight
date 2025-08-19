package net.magicvt.extravagantdelight.compat;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BCCombatFoodValues extends FoodValues {


    public static final FoodProperties STARFRUIT_PALOMA = (new FoodProperties.Builder())
            .effect(new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, false, false), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties PINK_GIN = (new FoodProperties.Builder())
            .effect(new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, false, false), 1.0F)
            .effect(new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties SLOE_GIN = (new FoodProperties.Builder())
            .effect(new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, false, false), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties SLOE_VODKA = (new FoodProperties.Builder())
            .effect(new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, false, false), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F)
            .alwaysEat()
            .build();




}
