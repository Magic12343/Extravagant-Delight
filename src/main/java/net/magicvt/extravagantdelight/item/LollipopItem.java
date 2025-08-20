package net.magicvt.extravagantdelight.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;

public class LollipopItem extends Item {
    private final int maxBites;
    private final FoodProperties food;

    public LollipopItem(Properties properties, FoodProperties food, int maxBites) {
        super(properties.stacksTo(1).food(food));
        this.food = food;
        this.maxBites = maxBites;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            player.getFoodData().eat(food.getNutrition(), food.getSaturationModifier());

            if (!level.isClientSide) {
                for (var pair : food.getEffects()) {
                    if (pair.getFirst() != null && level.random.nextFloat() < pair.getSecond()) {
                        player.addEffect(new MobEffectInstance(pair.getFirst()));
                    }
                }

                int bites = stack.getOrCreateTag().getInt("Bites") + 1;
                stack.getOrCreateTag().putInt("Bites", bites);

                level.playSound(null, player.blockPosition(),
                        SoundEvents.HONEY_DRINK, SoundSource.PLAYERS, 0.8F, 1.0F);

                if (bites >= maxBites) {
                    return ItemStack.EMPTY;
                }
            }
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        int bites = stack.getOrCreateTag().getInt("Bites");
        return bites > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        int bites = stack.getOrCreateTag().getInt("Bites");
        return Math.round(13.0F - (13.0F * bites / (float) maxBites));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        int bites = stack.getOrCreateTag().getInt("Bites");
        float ratio = (float)(maxBites - bites) / maxBites;
        return Mth.hsvToRgb(ratio / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
        return super.hurtEnemy(stack, target, attacker);
    }

    public boolean onLeftClickEntity(ItemStack stack, Player player, LivingEntity entity) {
        if (!player.level().isClientSide) {
            if (player.getCooldowns().isOnCooldown(this)) {
                return true;
            }
            player.getCooldowns().addCooldown(this, 10);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
