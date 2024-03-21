package com.lzimul.LawAssistAdventure.client.util;

import net.minecraft.resources.ResourceLocation;

import java.util.logging.Logger;

public class ConfigUtil {
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
}
