package com.lzimul.LawAssistAdventure;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;
import java.util.logging.Logger;

public class Config {
    public static final String MODID = "law_assist_adventure";
    public static final Logger LOGGER = Logger.getLogger(MODID);

    public static ResourceLocation getHudResourceLocation(String name) {
        return new ResourceLocation(MODID, "textures/gui/hud/" + name + ".png");
    }

    public static ResourceLocation getItemResourceLocation(String name) {
        return new ResourceLocation(MODID, "textures/gui/item/" + name + ".png");
    }

    public static ResourceLocation getBlockResourceLocation(String name) {
        return new ResourceLocation(MODID, "textures/gui/block/" + name + ".png");
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
    public static void shrinkItem(Player player, Item item, int num) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem().asItem().equals(item)) {
                player.getInventory().getItem(player.getInventory().items.indexOf(itemStack)).shrink(num);
                break;
            }
        }
    }
}
