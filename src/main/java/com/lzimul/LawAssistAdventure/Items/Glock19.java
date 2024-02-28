package com.lzimul.LawAssistAdventure.Items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Glock19 extends Item {
    public Glock19() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide() && player.isAlive()) {
            Vec3 forward = player.getForward();
            player.sendSystemMessage(Component.literal(forward.toString()));
            player.kill();
        }
        return super.use(level, player, hand);
    };
}
