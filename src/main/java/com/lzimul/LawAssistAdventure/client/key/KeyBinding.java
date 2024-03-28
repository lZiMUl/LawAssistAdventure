package com.lzimul.LawAssistAdventure.client.key;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final KeyMapping KeyboardR = new KeyMapping("key.law_assist_adventure.mouse.r", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.law_assist_adventure.category.misc");
    public static final KeyMapping MouseLeftButton = new KeyMapping("key.law_assist_adventure.mouse.left", InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_LEFT, "key.law_assist_adventure.category.misc");
    public static final KeyMapping MouseRightButton = new KeyMapping("key.law_assist_adventure.mouse.right",InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_RIGHT, "key.law_assist_adventure.category.misc");

}
