package com.lzimul.LawAssistAdventure;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

public class Config {
    public static final String MODID = "law_assist_adventure";
    public static final Logger LOGGER = Logger.getLogger(MODID);

    public static void setAllBlockRenderLayer(Class<?> targetClass) throws IllegalAccessException {
        for (Field field : targetClass.getDeclaredFields()) {
            int fieldIndex = field.getModifiers();
            if (Modifier.isPublic(fieldIndex) && Modifier.isStatic(fieldIndex)) {
                ItemBlockRenderTypes.setRenderLayer(((DeferredBlock<Block>) field.get(null)).get(), RenderType.cutout());
            }
        }
    }
}
