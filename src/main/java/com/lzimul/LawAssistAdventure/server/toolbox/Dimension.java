package com.lzimul.LawAssistAdventure.server.toolbox;
// TODO 降落伞丢失

import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Dimension implements ITeleporter {
    private final BlockPos blockPos;

    public Dimension(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    private static boolean isAirOrStone(LevelChunk chunk, BlockPos pos) {
        BlockState state = chunk.getBlockState(pos);
        return state.getBlock().equals(Blocks.STONE) || state.isAir();
    }

    private static boolean isReplaceable(Level world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock().equals(Blocks.STONE) ||
                state.getBlock().equals(Blocks.GRANITE) ||
                state.getBlock().equals(Blocks.ANDESITE) ||
                state.getBlock().equals(Blocks.DIORITE) ||
                state.getBlock().equals(Blocks.DIRT) ||
                state.getBlock().equals(Blocks.GRAVEL) ||
                state.getBlock().equals(Blocks.LAVA) ||
                state.isAir();
    }

    public static Vec3 getASafeArea(ServerLevel world, LevelChunk chunk) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int min = world.getMinBuildHeight();
        int max = world.getMaxBuildHeight() - 10;
        for (int y = max - 1; y >= min; y = y - 1) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    pos.set(x, y, z);
                    if (chunk.getBlockState(pos).isAir() && chunk.getBlockState(pos.above(1)).isAir() && chunk.getBlockState(pos.above(2)).isAir()) {
                        BlockPos absolutePos = chunk.getPos().getWorldPosition().offset(pos.getX(), pos.getY(), pos.getZ());
                        return new Vec3(absolutePos.getX() + 0.5, absolutePos.getY() + 1, absolutePos.getZ() + 0.5);
                    }
                }
            }
        }

        for (int y = max - 1; y >= min; y = y - 1) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    pos.set(x, y, z);
                    if (isAirOrStone(chunk, pos) && isAirOrStone(chunk, pos.above(1)) && isAirOrStone(chunk, pos.above(2))) {
                        BlockPos absolutePos = chunk.getPos().getWorldPosition().offset(pos.getX(), pos.getY(), pos.getZ());
                        if (isReplaceable(world, absolutePos.above(3)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.SOUTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.EAST)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.WEST)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.SOUTH)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.EAST)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.WEST))
                        ) {
                            world.setBlockAndUpdate(absolutePos.above(1), Blocks.AIR.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2), Blocks.AIR.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(3), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.NORTH), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.SOUTH), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.EAST), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.WEST), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.NORTH), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.SOUTH), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.EAST), Blocks.STONE.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.WEST), Blocks.STONE.defaultBlockState());
                            return new Vec3(absolutePos.getX() + 0.5, absolutePos.getY() + 1, absolutePos.getZ() + 0.5);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void teleportToWorld(Player player, ResourceKey<Level> levelResourceKey) {
        String worldId = levelResourceKey.location().toLanguageKey();
        Pattern pattern = Pattern.compile("minecraft|" + MODID);
        if (pattern.matcher(worldId).find() && player.level().dimension() != levelResourceKey) {
            player.sendSystemMessage(Component.translatable(worldId));
            ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(levelResourceKey);
            if (world != null) {
                player.changeDimension(world, new Dimension(player.getOnPos()));
                ItemStack slot = player.getItemBySlot(EquipmentSlot.CHEST);
                ItemStack source = new ItemStack(slot.getItem());
//                ItemStack target = new ItemStack(ItemRegister.Parachute.get().asItem());
                Inventory playerInventory = player.getInventory();
                if (!slot.isEmpty()) {
//                    if (!source.getItem().equals(target.getItem())) {
//                        if (HasEmptySlot(playerInventory)) {
//                            for (ItemStack item : playerInventory.items) {
//                                if (item.isEmpty()) {
//                                    playerInventory.setItem(playerInventory.items.indexOf(item), source);
////                                    player.setItemSlot(EquipmentSlot.CHEST, target);
//                                    break;
//                                }
//                            }
//                        } else {
//                            player.drop(source, true);
////                            player.setItemSlot(EquipmentSlot.CHEST, target);
//                        }
//                    }
                } else {
//                    player.setItemSlot(EquipmentSlot.CHEST, target);
                    player.playSound(SoundRegister.Demo.get());
                }
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 240, 1, true, true));
            } else {
                player.displayClientMessage(Component.translatable("event.law_assist_adventure.world.not_found"), true);
            }
        }
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