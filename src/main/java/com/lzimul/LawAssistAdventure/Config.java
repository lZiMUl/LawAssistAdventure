package com.lzimul.LawAssistAdventure;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


public class Config {
    public static final String MODID = "law_assist_adventure";
    public static final Logger LOGGER = Logger.getLogger(MODID);

    public static ResourceLocation getResourceLocation(ResourceType mode, String name) {
        return switch (mode) {
            case HUD -> new ResourceLocation(MODID, "textures/gui/hud/" + name + ".png");
            case ITEM -> new ResourceLocation(MODID, "textures/gui/item/" + name + ".png");
            case BLOCK -> new ResourceLocation(MODID, "textures/gui/block/" + name + ".png");
        };
    }

    public static String getDescriptionId(Level level, BlockPos blockPos) {
        return Objects.requireNonNull(level).getBlockState(blockPos).getBlock().getDescriptionId();
    }

    public static boolean isDistanceExceeded(PathfinderMob source, Player target, double range) {
        Vec3 sourcePosition = source.getPosition(0.5F);
        Vec3 targetPosition = target.getPosition(0.5F);
        double x = Math.pow(targetPosition.x - sourcePosition.x, 2);
        double y = Math.pow(targetPosition.y - sourcePosition.y, 2);
        double z = Math.pow(targetPosition.z - sourcePosition.z, 2);
        return Math.sqrt(x + y + z) > range;
    }

    public static boolean hasItem(Player player, Item item) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem().asItem().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void shrinkItem(Player player, Item item, Item repliItem, int num) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem().asItem().equals(item)) {
                player.getInventory().getItem(player.getInventory().items.indexOf(itemStack)).shrink(num);
                player.getInventory().add(new ItemStack(repliItem));
                break;
            }
        }
    }

    public static ArrayList<Vec3> getRay(Player player, int distance) {
        Vec3 playerPosition = player.getPosition(0);
        Vec2 playerRotation = player.getRotationVector();

        double sinYaw = Math.sin(-Math.toRadians(playerRotation.y));
        double cosYaw = Math.cos(-Math.toRadians(playerRotation.y));
        double sinPitch = Math.sin(-Math.toRadians(playerRotation.x));
        double cosPitch = Math.cos(-Math.toRadians(playerRotation.x));

        Vec3 direction = new Vec3(sinYaw * cosPitch, sinPitch, cosYaw * cosPitch).normalize();
        Vec3 rayStart = playerPosition.add(new Vec3(0, player.getEyeHeight() - 1, -1));
        Vec3 rayEnd = rayStart.add(direction.multiply(new Vec3(distance, distance, distance)));

        int numPoints = distance + 1;

        ArrayList<Vec3> points = new ArrayList<>(numPoints);

        for (int index = 0; index < numPoints; index++) {
            double interpolation = (double) index / (numPoints - 1);

            double x = rayStart.x + (rayEnd.x - rayStart.x) * interpolation;
            double y = rayStart.y + (rayEnd.y - rayStart.y) * interpolation;
            double z = rayStart.z + (rayEnd.z - rayStart.z) * interpolation;

            points.add(new Vec3(x, y, z));
        }

        return points;
    }

    public static Entity getEntityAtPoint(Player player, Vec3 point) {
        // TODO point.add(不准确, 需要手动调整)
        List<Entity> entities = player.level().getEntities(player, AABB.ofSize(point.add(0, 1, 0), 0.5, 0.5, 0.5));
        for (Entity entity : entities) {
            if (entity.isAlive()) {
                return entity;
            }
        }
        return null;
    }

    public static BlockPos Vec3ToBlockPos(Vec3 vec3) {
        return new BlockPos(new Vec3i((int) vec3.x, (int) vec3.y, (int) vec3.z));
    }

    public static boolean DestroyObstacles(Level level, BlockPos blockPos, List<Block> blocks) {
        for (Block block : blocks) {
            if (block.getDescriptionId().equals(getDescriptionId(level, blockPos))) {
                return level.destroyBlock(blockPos, true);
            }
        }
        return level.getBlockState(blockPos).is(Blocks.AIR);
    }

    public enum ResourceType {
        HUD,
        ITEM,
        BLOCK
    }
}
