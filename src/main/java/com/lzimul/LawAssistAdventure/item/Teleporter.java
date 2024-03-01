package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.MenuRegister;
import com.lzimul.LawAssistAdventure.block.CraftingTable;
import com.lzimul.LawAssistAdventure.dimension.Dust;
import com.lzimul.LawAssistAdventure.menu.item.TeleporterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Teleporter extends Item implements MenuProvider {
    public Teleporter() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && player.isAlive()) {
//            if (player.level().dimension() == OVERWORLD) {
//                teleportToWorld((ServerPlayer) player, THE_END, player.getOnPos());
//            } else {
//                teleportToWorld((ServerPlayer) player, OVERWORLD, player.getOnPos());
//            }
            player.openMenu(this);
            ItemStack source = player.getItemBySlot(EquipmentSlot.HEAD);
            if (!source.isEmpty()) {
                for (ItemStack item : player.getInventory().items) {
                    if (item.isEmpty()) {
//                        player.setItemSlot(EquipmentSlot.Type.HAND, new ItemStack(source.getItem(), 1));
                        break;
                    }
                }
//                player.drop(source, true);
            }
//            if (!source.equals(new ItemStack(ItemRegister.Parachute.get()))) {
//                player.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ItemRegister.Parachute.get(), 1));
//            }
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1, 60, true, true));
        }
        return super.use(level, player, hand);
    }
    private void teleportToWorld(ServerPlayer player, ResourceKey<Level> dimension, BlockPos pos) {
        ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(dimension);
        if (world != null) {
            player.changeDimension(world, new Dust(pos));
        } else {
            player.displayClientMessage(Component.literal("the world not found."), true);
        }
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("item.law_assist_adventure.teleporter");
    }

    @Override
    public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new AbstractContainerMenu(MenuRegister.TeleporterMenu.get(), i) {
            @Override
            public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
                try {
                    return new ItemStack(Teleporter.class.newInstance(), 1);
                } catch (IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public boolean stillValid(@NotNull Player p_38874_) {
                return true;
            };
        };
    };
}
