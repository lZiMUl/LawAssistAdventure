package com.lzimul.LawAssistAdventure.register;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyRegister {
    public static final String keyTitle = "key.law_assist_adventure";
    public static final KeyMapping KeyboardR = new KeyMapping("key.law_assist_adventure.keyboard.r", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, keyTitle);
    public static final KeyMapping MouseLeftButton = new KeyMapping("key.law_assist_adventure.mouse.left", InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_LEFT, keyTitle);
    public static final KeyMapping MouseRightButton = new KeyMapping("key.law_assist_adventure.mouse.right", InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_RIGHT, keyTitle);

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyRegister.KeyboardR);
        event.register(KeyRegister.MouseLeftButton);
        event.register(KeyRegister.MouseRightButton);
    }
}