package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.occupation.Occupation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class NoOccupation extends Item {
    public NoOccupation() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && player.isAlive()) {
            new Occupation(player, com.lzimul.LawAssistAdventure.occupation.NoOccupation::new);
        }
        return super.use(level, player, hand);
    }
}
