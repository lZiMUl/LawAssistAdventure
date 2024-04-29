package com.lzimul.LawAssistAdventure.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.neoforged.neoforge.client.gui.GuiLayerManager;
import org.jetbrains.annotations.NotNull;

public class MainHud extends GuiLayerManager {
    private final Minecraft minecraft;

    public MainHud() {
        this.minecraft = Minecraft.getInstance();
    }

    public static LayeredDraw.Layer getInstance() {
        return (LayeredDraw.Layer) new MainHud();
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, float partialTick) {
        assert this.minecraft.level != null;
        if (this.minecraft.level.isClientSide()) {
            guiGraphics.setColor(1, 1, 1, 1);
            // TODO Fix the issue
//            guiGraphics.blit(getResourceLocation(Config.ResourceType.HUD, "main_hud"), 0, 0, 0, 0, screenWidth, screenHeight, screenWidth / 64, screenHeight / 64);
        }
    }
}