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
    public static final FoodProperties SLOE_BERRY_CUPCAKE = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.7f).build();
    public static final FoodProperties STARFRUIT_JUICE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties STARFRUIT_CHEESECAKE_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();

    public static final FoodProperties BOILED_QUINCE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties BOILED_QUINCE_PULP = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.2f).build();
    public static final FoodProperties QUINCE_CANDY = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties QUINCE_COOKIE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.3f).build();
    public static final FoodProperties SLOE_BERRY_COOKIE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.5f).build();
    public static final FoodProperties QUINCE_JELLY = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties SWEET_QUINCE_TART_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 400, 0), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_JUICE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.3f).build();
    public static final FoodProperties QUINCE_JUICE = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.3f).build();

    public static final FoodProperties SLOE_BERRY_JELLY = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f).build();
    public static final FoodProperties SLOE_TREACLE_TART_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false), 1.0F).build();

    public static final FoodProperties STARFRUIT_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();
    public static final FoodProperties QUINCE_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false), 1.0F).build();

    public static final FoodProperties STARFRUIT_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(1.6F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();
    public static final FoodProperties QUINCE_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(1.6F).alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(1.6F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false), 1.0F).build();

    public static final FoodProperties STARFRUIT_WINE = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1), 1.0F)
            .build();
    public static final FoodProperties QUINCE_WINE = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 5000, 1), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_WINE = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 1), 1.0F)
            .build();

    public static final FoodProperties STARFRUIT_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F)
            .build();
    public static final FoodProperties QUINCE_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0F)
            .build();

    public static final FoodProperties VEGETABLE_OIL = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0F)
            .build();
    public static final FoodProperties MAYO = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 1), 1.0F)
            .build();

    public static final FoodProperties APPLE_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1.0F)
            .build();
    public static final FoodProperties SWEET_BERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
            .build();
    public static final FoodProperties GLOW_BERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1.0F)
            .build();
    public static final FoodProperties STARFRUIT_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F)
            .build();
    public static final FoodProperties SLOE_BERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
            .build();
    public static final FoodProperties BLUEBERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1.0F)
            .build();
    public static final FoodProperties RASPBERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
            .build();
    public static final FoodProperties SALMONBERRY_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1.0F)
            .build();
    public static final FoodProperties SWEET_BERRY_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0F)
            .build();
    public static final FoodProperties GLOW_BERRY_LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F)
            .build();
    public static final FoodProperties PASSIONFRUIT_YOGURT = (new FoodProperties.Builder())
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F)
            .build();




}
