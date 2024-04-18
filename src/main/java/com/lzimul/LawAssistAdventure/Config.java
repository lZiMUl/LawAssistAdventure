package com.lzimul.LawAssistAdventure;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.function.TriConsumer;

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

    public enum ResourceType {
        HUD,
        ITEM,
        BLOCK
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

    public static class Array<T> {
        private final T[] data;

        public Array(T[] data) {
            this.data = data;
        }

        public void forEach(TriConsumer<T, Integer, T[]> callback) {
            for (int index = 0; index < this.data.length; index++) {
                callback.accept(this.data[index], index, this.data);
            }
        }
    }
}
