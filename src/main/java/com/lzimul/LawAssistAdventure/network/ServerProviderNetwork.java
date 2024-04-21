package com.lzimul.LawAssistAdventure.network;

import com.lzimul.LawAssistAdventure.item.Ak47Item;
import com.lzimul.LawAssistAdventure.item.Glock19Item;
import com.lzimul.LawAssistAdventure.item.HarquebusItem;
import com.lzimul.LawAssistAdventure.item.PearFlowerGunItem;
import com.lzimul.LawAssistAdventure.register.DimensionRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.core.BlockPos;
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
                case "server:keyBoard/R":
                    switch (player.getMainHandItem().getItem().getDescriptionId()) {
                        case "item.law_assist_adventure.ak47":
                            Ak47Item.reload(player);
                            break;
                        case "item.law_assist_adventure.glock19":
                            Glock19Item.reload(player);
                            break;
                        case "item.law_assist_adventure.pear_flower_gun":
                            PearFlowerGunItem.reload(player);
                            break;
                        case "item.law_assist_adventure.harquebus":
                            HarquebusItem.reload(player);
                            break;
                    }
                    break;
                case "server:keyBoard/C":
                    if (player.getMainHandItem().getItem().getDescriptionId().equals("item.law_assist_adventure.glock19")) {
                        if (Glock19Item.fireNum == 1) {
                            Glock19Item.fireNum = 3;
                        } else {
                            Glock19Item.fireNum = 1;
                        }
                    }
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
                player.changeDimension(world, new Dimension(player.getOnPos()));
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
                player.displayClientMessage(Component.translatable("event.law_assist_adventure.world.not_found"), true);
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
    private final BlockPos blockPos;

    public Dimension(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Override
    public @NotNull Entity placeEntity(@NotNull Entity rawEntity, @NotNull ServerLevel currentWorld, @NotNull ServerLevel destWorld, float yaw, @NotNull Function<Boolean, Entity> repositionEntity) {
        Entity entity = repositionEntity.apply(true);
        if (!(entity instanceof ServerPlayer player)) {
            return entity;
        }
        Vec3 spawnPos = getASafeArea(destWorld, (LevelChunk) destWorld.getChunk(blockPos));
        if (spawnPos != null) {
            player.teleportTo(spawnPos.x(), spawnPos.y(), spawnPos.z());
        }
        return entity;
    }
}
