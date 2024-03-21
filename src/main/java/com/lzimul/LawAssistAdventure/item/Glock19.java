package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.AmmunitionHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Glock19 extends Item {
    private static final AmmunitionHelper ammunitionHelper = new AmmunitionHelper(21, 120, 0);

    public Glock19() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide() && player.isAlive()) {
            ammunitionHelper.setPlayer(player);
            player.sendSystemMessage(Component.literal("弹药: " + "[" + ammunitionHelper.getCurrent() + "/" + ammunitionHelper.getLimit() + "/" + ammunitionHelper.getTotal() + "]"));
            if (player.isCrouching()) {
                if (ammunitionHelper.getCurrent() != ammunitionHelper.getLimit()) {
                    if (ammunitionHelper.getTotal() != 0) {
                        ammunitionHelper.reload();
                        player.sendSystemMessage(Component.literal("已装弹。"));
                    } else {
                        player.sendSystemMessage(Component.literal("备弹空"));
                    }
                } else {
                    player.sendSystemMessage(Component.literal("弹药已满。"));
                }
            } else if (ammunitionHelper.getCurrent() != 0) {
                ammunitionHelper.fire(1);
            } else {
                player.sendSystemMessage(Component.literal("弹药不足。"));
            }
        }
        return super.use(level, player, hand);
    }
}
