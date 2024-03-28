package com.lzimul.LawAssistAdventure.network;

import com.lzimul.LawAssistAdventure.register.DimensionRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.ITeleporter;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.lzimul.LawAssistAdventure.Config.MODID;
import static com.lzimul.LawAssistAdventure.register.DimensionRegister.getASafeArea;

public class ServerProviderNetwork {

    private static final ServerProviderNetwork INSTANCE = new ServerProviderNetwork();

    public static ServerProviderNetwork getInstance() {
        return INSTANCE;
    }

    public void handleData(final DataNetwork networkData, final PlayPayloadContext playPayloadContext) {
        playPayloadContext.player().ifPresent((player) -> playPayloadContext.workHandler().submitAsync(() -> {
            String data = networkData.data();
            player.sendSystemMessage(Component.literal("我从服务端得到了这个数据:" + data));
            switch (data) {
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
                case "server:occupation/Dimension":
                    teleportToWorld(player, DimensionRegister.Overworld);
                    break;
                case "server:occupation/TheNether":
                    teleportToWorld(player, DimensionRegister.TheNether);
                    break;
                case "server:occupation/TheEnd":
                    teleportToWorld(player, DimensionRegister.TheEnd);
                    break;
                default:
                    playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure.no_occupation"));
            }
        }).exceptionally(e -> {
            playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure." + e.getMessage()));
            return null;
        }));
    }

    private void teleportToWorld(Player player, ResourceKey<Level> levelResourceKey) {
        String worldId = levelResourceKey.location().toLanguageKey();
        Pattern pattern = Pattern.compile("minecraft|" + MODID);
        if (pattern.matcher(worldId).find() && player.level().dimension() != levelResourceKey) {
            player.sendSystemMessage(Component.translatable(worldId));
            ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(levelResourceKey);
            if (world != null) {
                player.changeDimension(world, new Dimension());
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

    public boolean hasEmptySlot(Inventory inventory) {
        for (ItemStack itemStack : inventory.items) {
            if (itemStack.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

class Dimension implements ITeleporter {
    @Override
    public @NotNull Entity placeEntity(@NotNull Entity entity, @NotNull ServerLevel currentWorld, @NotNull ServerLevel destWorld, float yaw, @NotNull Function<Boolean, Entity> repositionEntity) {
        if (!(entity instanceof ServerPlayer player)) {
            return entity;
        }
        LevelChunk chunk = (LevelChunk) destWorld.getChunk(player.getOnPos());
        Vec3 spawnPos = getASafeArea(destWorld, chunk);

        if (spawnPos == null) {
            return entity;
        }

        player.giveExperienceLevels(0);
        player.teleportTo(spawnPos.x(), spawnPos.y(), spawnPos.z());
        return entity;
    }
}
