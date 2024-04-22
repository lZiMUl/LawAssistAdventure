package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.AmmunitionHelper;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static com.lzimul.LawAssistAdventure.Config.*;

public class HarquebusItem extends Item {
    public static final AmmunitionHelper ammunitionHelper = new AmmunitionHelper(1, 10, 0);
    private static final List<Block> targetBlocks = Arrays.stream(new Block[]{
            Blocks.GLASS,
            Blocks.GLASS_PANE,
            Blocks.OAK_LOG,
            Blocks.STONE
    }).distinct().toList();

    public HarquebusItem() {
        super(new Item.Properties());
    }

    public static void reload(Player player) {
        if (ammunitionHelper.getCurrent() != ammunitionHelper.getLimit()) {
            if (ammunitionHelper.getTotal() != 0) {
                ammunitionHelper.reload();
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.Glock19Reload.get(), player.getSoundSource(), 1.0F, 1.0F);
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.reloaded"));
            } else {
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.empty"));
            }
        } else {
            player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.full"));
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (!level.isClientSide() && player.isAlive()) {
            ammunitionHelper.setPlayer(player);
            if (ammunitionHelper.getCurrent() != 0) {
                ammunitionHelper.fire(1, (index) -> {
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.Glock19Fire.get(), player.getSoundSource(), 1.0F, 1.0F);
                    for (Vec3 point : getRay(player, 37)) {
                        BlockPos blockPos = Vec3ToBlockPos(new Vec3(point.x, point.y, point.z));
                        Entity hitEntity = getEntityAtPoint(player, point);
                        if (DestroyObstacles(level, blockPos, targetBlocks) && hitEntity != null) {
                            player.attack(hitEntity);
                        }
                    }
                });
            } else {
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.low"));
            }
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Level level, @NotNull List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            componentList.add(Component.translatable("tip.law_assist_adventure.item.shift").withStyle(ChatFormatting.AQUA));
        } else {
            componentList.add(Component.literal("不知道").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}
