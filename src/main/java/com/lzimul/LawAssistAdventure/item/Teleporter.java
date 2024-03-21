package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.dimension.FinalWing;
import com.lzimul.LawAssistAdventure.register.DimensionRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.MenuRegister;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
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

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public class Teleporter extends Item implements MenuProvider {
    public Teleporter() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && player.isAlive()) {
            ResourceKey<Level>[] dimension = new ResourceKey[]{
//                    DimensionRegister.TheNether,
//                    DimensionRegister.TheEnd,
//                    DimensionRegister.Dust,
//                    DimensionRegister.FallIntoTheVoid,
                    DimensionRegister.FinalWing,
//                    DimensionRegister.RemnantDawn,
//                    DimensionRegister.Staring
            };
            if (player.level().dimension() == DimensionRegister.Overworld) {
                ResourceKey<Level> world = this.getWorld(dimension);
                String worldId = world.location().toLanguageKey();
                if (worldId.contains(MODID)) {
                    player.sendSystemMessage(Component.translatable(worldId));
                }
                teleportToWorld((ServerPlayer) player, world, player.getOnPos());
            } else {
                teleportToWorld((ServerPlayer) player, DimensionRegister.Overworld, player.getOnPos());
            }
//            player.openMenu(this);
            ItemStack slot = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack source = new ItemStack(slot.getItem());
            ItemStack target = new ItemStack(ItemRegister.Parachute.get().asItem());
            Inventory playerInventory = player.getInventory();
            if (!slot.isEmpty()) {
                if (!source.getItem().equals(target.getItem())) {
                    if (hasEmptySlot(playerInventory)) {
                        for (ItemStack item : playerInventory.items) {
                            if (item.isEmpty()) {
                                playerInventory.setItem(playerInventory.items.indexOf(item), source);
                                player.setItemSlot(EquipmentSlot.CHEST, target);
                                break;
                            }
                        }
                    } else {
                        player.drop(source, true);
                        player.setItemSlot(EquipmentSlot.CHEST, target);
                    }
                }
            } else {
                player.setItemSlot(EquipmentSlot.CHEST, target);
                player.playSound(SoundRegister.Demo.get());
            }
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 240, 1, true, true));
        }
        return InteractionResultHolder.sidedSuccess(this.getDefaultInstance(), level.isClientSide);
    }

    public boolean hasEmptySlot(Inventory inventory) {
        for (ItemStack itemStack : inventory.items) {
            if (itemStack.isEmpty()) {
                return true;
            }
        }
        return false;
    }


    private ResourceKey<Level> getWorld(ResourceKey<Level>[] dimensions) {
        double random = Math.random() * dimensions.length;
        return dimensions[(int) random];
    }

    private void teleportToWorld(ServerPlayer player, ResourceKey<Level> dimension, BlockPos pos) {
        ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(dimension);
        if (world != null) {
            player.changeDimension(world, new FinalWing(pos));
        } else {
            player.displayClientMessage(Component.literal("the world not found."), true);
        }
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(this.getDescriptionId());
    }

    @Override
    public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new AbstractContainerMenu(MenuRegister.TeleporterMenu.get(), i) {
            @Override
            public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
                return new ItemStack(Teleporter.this);
            }

            @Override
            public boolean stillValid(@NotNull Player p_38874_) {
                return true;
            }
        };
    }
}
