package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.OccupationHelper;
import com.lzimul.LawAssistAdventure.occupation.FallIntoTheVoid;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FallIntoTheVoidOccupationItem extends Item {
    private static final OccupationHelper<FallIntoTheVoid> occupationHelper = new OccupationHelper<>(FallIntoTheVoid::new);
    public FallIntoTheVoidOccupationItem() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && player.isAlive()) {
            occupationHelper.use(player);
        }
        return super.use(level, player, hand);
    }
}
