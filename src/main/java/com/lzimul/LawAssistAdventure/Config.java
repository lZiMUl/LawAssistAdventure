package com.lzimul.LawAssistAdventure;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

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
}
