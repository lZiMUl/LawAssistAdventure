package com.lzimul.LawAssistAdventure.network;

import com.lzimul.LawAssistAdventure.dimension.FinalWing;
import com.lzimul.LawAssistAdventure.register.DimensionRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import java.util.Objects;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ServerProviderNetwork {

    private static final ServerProviderNetwork INSTANCE = new ServerProviderNetwork();

    public static ServerProviderNetwork getInstance() {
        return INSTANCE;
    }


    public void handleData(final DataNetwork networkData, final PlayPayloadContext playPayloadContext) {
        try {
            playPayloadContext.player().ifPresent((player) -> playPayloadContext.workHandler().submitAsync(() -> {
                String data = networkData.data();
                player.sendSystemMessage(Component.literal("我从服务端得到了这个数据:" + data));
                switch (data) {
                    case "server:menu/CraftingTableBlock": {
                    }
                    break;
                    case "server:menu/114514": {
                        player.sendSystemMessage(Component.literal("114514"));
                    }
                    break;
                    case "server:occupation/Dust":
                        teleportToWorld(player, DimensionRegister.Dust);
                        break;
                    case "server:occupation/FallIntoTheVoid":
                        teleportToWorld(player, DimensionRegister.FallIntoTheVoid);
                        break;
                    case "server:occupation/FinalWing":
                        teleportToWorld(player, DimensionRegister.FinalWing);
                        break;
                    case "server:occupation/RemnantDawn":
                        teleportToWorld(player, DimensionRegister.RemnantDawn);
                        break;
                    case "server:occupation/Staring":
                        teleportToWorld(player, DimensionRegister.Staring);
                        break;
                    case "server:occupation/Overworld":
                        teleportToWorld(player, DimensionRegister.Overworld);
                        break;
                    case "server:occupation/TheNether":
                        teleportToWorld(player, DimensionRegister.TheNether);
                        break;
                    case "server:occupation/TheEnd":
                        teleportToWorld(player, DimensionRegister.TheEnd);
                        break;

                }
            }).exceptionally(e -> {
                playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure.failed1"));
                return null;
            }));
        } catch (Exception ignored) {
        }
    }

    private void teleportToWorld(Player player, ResourceKey<Level> levelResourceKey) {
        String worldId = levelResourceKey.location().toLanguageKey();
        if (worldId.contains(MODID)) {
            player.sendSystemMessage(Component.translatable(worldId));
            if (player.level().dimension() != levelResourceKey) {
                ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(levelResourceKey);
                if (world != null) {
                    player.changeDimension(world, new FinalWing(player.getOnPos()));
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
                } else {
                    player.displayClientMessage(Component.literal("the world not found."), true);
                }
            }
        }
    }

    public boolean hasEmptySlot(Inventory inventory) {
        for (ItemStack itemStack : inventory.items) {
            if (itemStack.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
