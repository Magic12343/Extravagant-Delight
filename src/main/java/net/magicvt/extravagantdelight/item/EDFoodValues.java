package net.magicvt.extravagantdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import vectorwing.farmersdelight.common.FoodValues;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class EDFoodValues extends FoodValues {

    public static final FoodProperties STARFRUIT_SALAD = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.7f).build();
    public static final FoodProperties STARFRUIT_SALMON = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.75f).build();
    public static final FoodProperties STARFRUIT_POPSICLE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.3f).fast().alwaysEat().build();
    public static final FoodProperties STARFRUIT_JAM = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties STARFRUIT_MUFFIN = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties STARFRUIT_JUICE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties STARFRUIT_CHEESECAKE_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();


}
