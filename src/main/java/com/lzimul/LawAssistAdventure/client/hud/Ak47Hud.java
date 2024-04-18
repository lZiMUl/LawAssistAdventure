package com.lzimul.LawAssistAdventure.client.hud;

import com.lzimul.LawAssistAdventure.Config;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.getResourceLocation;

public class Ak47Hud implements IGuiOverlay {
    private final Minecraft minecraft;
    private final int imageWidth;
    private final int imageHeight;

    public Ak47Hud() {
        this.minecraft = Minecraft.getInstance();
        this.imageWidth = 1080 / 10;
        this.imageHeight = 607 / 10;
    }

    public static Ak47Hud getInstance() {
        return new Ak47Hud();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        assert minecraft.player != null;
        if (minecraft.player.getMainHandItem().getItem() == ItemRegister.Ak47.get().asItem()) {
            guiGraphics.setColor(1, 1, 1, 1);
            guiGraphics.blit(getResourceLocation(Config.ResourceType.HUD, "ak47_hud"), screenWidth - imageWidth, screenHeight - imageHeight, 0, 0, screenWidth - 10, screenHeight - 10, imageWidth, imageHeight);
        }
    }
}
