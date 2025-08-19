package net.magicvt.extravagantdelight.compat;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class IceCreamItem extends ConsumableItem {

    public IceCreamItem(Properties properties) {
        super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, LivingEntity entity) {
        entity.setTicksFrozen(entity.getTicksFrozen() + 200);
        return (entity instanceof Player p && p.getAbilities().instabuild) ?
                super.finishUsingItem(stack, level, entity) :
                new ItemStack(Items.BOWL);
    }

}