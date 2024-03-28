package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PearFlowerGun extends Item {
    public PearFlowerGun() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (!level.isClientSide() && player.isAlive()) {
            if (interactionHand == InteractionHand.MAIN_HAND) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.Demo.get(), player.getSoundSource(), 1.0F, 1.0F);
            }

        }
        return super.use(level, player, interactionHand);
    }
}
