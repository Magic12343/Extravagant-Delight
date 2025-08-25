package net.magicvt.extravagantdelight.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class SloeBerriesItem extends Item {
    private static final int NAUSEA_APPLY_COUNT = 3;
    private static final int NAUSEA_DURATION = 100;
    private static final int RESET_TIME = 200;

    public SloeBerriesItem(Properties properties) {
        super(properties.food(
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.1F)
                        .build()
        ));
    }


    public ItemStack finishUsingItem(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            int counter = player.getPersistentData().getInt("SloeBerriesConsumeCount");
            long lastTime = player.getPersistentData().getLong("SloeBerriesLastConsumeTime");
            long currentTime = world.getGameTime();

            if (currentTime - lastTime > RESET_TIME) {
                counter = 0;
            }

            counter++;
            player.getPersistentData().putInt("SloeBerriesConsumeCount", counter);
            player.getPersistentData().putLong("SloeBerriesLastConsumeTime", currentTime);

            if (counter >= NAUSEA_APPLY_COUNT) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, NAUSEA_DURATION, 0));
                player.getPersistentData().putInt("SloeBerriesConsumeCount", 0);
            }
        }

        return super.finishUsingItem(stack, world, player);
    }
}
