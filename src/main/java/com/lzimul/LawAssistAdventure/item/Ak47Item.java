package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.AmmunitionHelper;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Ak47Item extends Item {
    public static final AmmunitionHelper ammunitionHelper = new AmmunitionHelper(30, 270, 0);

    public Ak47Item() {
        super(new Item.Properties().stacksTo(1));
    }

    public static void reload(Player player) {
        if (ammunitionHelper.getCurrent() != ammunitionHelper.getLimit()) {
            if (ammunitionHelper.getTotal() != 0) {
                ammunitionHelper.reload();
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.AK47Reload.get(), player.getSoundSource(), 1.0F, 1.0F);
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.reloaded"));
            } else {
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.empty"));
            }
        } else {
            player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.full"));
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide() && player.isAlive()) {
            ammunitionHelper.setPlayer(player);
            if (ammunitionHelper.getCurrent() != 0) {
                ammunitionHelper.fire(1);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.AK47Fire.get(), player.getSoundSource(), 1.0F, 1.0F);
            } else {
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.low"));
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Level level, @NotNull List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            componentList.add(Component.translatable("tip.law_assist_adventure.item.shift").withStyle(ChatFormatting.AQUA));
        } else {
            componentList.add(Component.translatable("tip.law_assist_adventure.item.ak47.full").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}
