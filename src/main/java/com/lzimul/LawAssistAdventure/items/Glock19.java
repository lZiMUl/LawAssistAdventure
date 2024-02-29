package com.lzimul.LawAssistAdventure.items;

import com.lzimul.LawAssistAdventure.ees.Ammunition;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Glock19 extends Item {
    private static final Ammunition ammunition = new Ammunition(21, 120, 0);
    public Glock19() {
        super(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0)
                .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 255, 1, true, true), 1)
                .build()
        ));
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide() && player.isAlive()) {
            ammunition.setPlayer(player);
            player.sendSystemMessage(Component.literal("弹药: " + "[" + ammunition.getCurrent() + "/" + ammunition.getLimit() + "/" + ammunition.getTotal() + "]"));
            if (player.isCrouching()) {
                if (ammunition.getCurrent() != ammunition.getLimit()) {
                    if (ammunition.getTotal() != 0) {
                        ammunition.reload();
                        player.sendSystemMessage(Component.literal("已装弹。"));
                    } else {
                        player.sendSystemMessage(Component.literal("备弹空"));
                    }
                } else {
                    player.sendSystemMessage(Component.literal("弹药已满。"));
                }
            } else if (ammunition.getCurrent() != 0) {
                ammunition.fire(1);
            } else {
                player.sendSystemMessage(Component.literal("弹药不足。"));
            }
        }
        return super.use(level, player, hand);
    };
}
