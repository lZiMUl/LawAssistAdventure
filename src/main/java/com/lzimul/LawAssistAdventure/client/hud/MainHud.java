package com.lzimul.LawAssistAdventure.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

public class MainHud implements IGuiOverlay {
    private final Minecraft minecraft;

    public MainHud() {
        this.minecraft = Minecraft.getInstance();
    }

    public static MainHud getInstance() {
        return new MainHud();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        assert this.minecraft.level != null;
        if (this.minecraft.level.isClientSide()) {
            guiGraphics.setColor(1, 1, 1, 1);
            // TODO Fix the issue
//            guiGraphics.blit(getHudResourceLocation("main_hud"), 0, 0, 0, 0, screenWidth, screenHeight, screenWidth / 64, screenHeight / 64);
        }
    }
}