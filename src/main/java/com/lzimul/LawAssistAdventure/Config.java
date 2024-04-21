package com.lzimul.LawAssistAdventure;

import net.minecraft.core.BlockPos;
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

    public static ArrayList<Vec3> getRay(Player player) {
        Vec3 rayStart = player.getPosition(0).add(-1, player.getEyeHeight() - 1, -1);
        Vec3 rayEnd = rayStart.add(player.getLookAngle().scale(100));
        int numPoints = (int) Math.sqrt(Math.pow(rayEnd.x - rayStart.x, 2) + Math.pow(rayEnd.y - rayStart.y, 2) + Math.pow(rayEnd.z - rayStart.z, 2));
        ArrayList<Vec3> points = new ArrayList<>(numPoints);
        for (int index = 0; index < numPoints; index++) {
            double t = (double) index / numPoints;
            double x = rayStart.x + t * (rayEnd.x - rayStart.x);
            double y = rayStart.y + t * (rayEnd.y - rayStart.y);
            double z = rayStart.z + t * (rayEnd.z - rayStart.z);
            points.add(new Vec3(x, y, z));
        }
        return points;
    }

    public static Entity getEntityAtPoint(Player player, Vec3 point) {
        List<Entity> entities = player.level().getEntities(player, AABB.unitCubeFromLowerCorner(point));
        for (Entity entity : entities) {
            if (entity.isAlive()) {
                return entity;
            }
        }
        return null;
    }

    public static boolean isAir(Level level, BlockPos blockPos, List<Block> blocks) {
        if (blocks.contains(level.getBlockState(blockPos).getBlock())) {
            level.destroyBlock(blockPos, true);
            return true;
        }
        return level.getBlockState(blockPos).is(Blocks.AIR);
    }

    public enum ResourceType {
        HUD,
        ITEM,
        BLOCK
    }
}
