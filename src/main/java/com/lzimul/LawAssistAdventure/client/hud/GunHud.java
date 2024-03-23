package com.lzimul.LawAssistAdventure.client.hud;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.getHudResourceLocation;

public class GunHud implements IGuiOverlay {
    private final Minecraft minecraft;
    private final int imageWidth;
    private final int imageHeight;

    public GunHud() {
        this.minecraft = Minecraft.getInstance();
        this.imageWidth = 1080 / 10;
        this.imageHeight = 607 / 10;
    }

    public static GunHud getInstance() {
        return new GunHud();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        assert minecraft.player != null;
        if (minecraft.player.getMainHandItem().getItem() == ItemRegister.Glock19.get().asItem()) {
            guiGraphics.setColor(1, 1, 1, 1);
            guiGraphics.blit(getHudResourceLocation("gun_hud"), screenWidth - imageWidth, screenHeight - imageHeight, 0, 0, screenWidth - 10, screenHeight - 10, imageWidth, imageHeight);
        }
    }
}