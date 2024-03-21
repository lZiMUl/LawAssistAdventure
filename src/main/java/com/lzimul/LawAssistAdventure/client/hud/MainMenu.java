package com.lzimul.LawAssistAdventure.client.hud;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;
import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.getHudResourceLocation;

public class MainMenu implements IGuiOverlay {
    private final int width;
    private final int height;
    private final Minecraft minecraft;

    public MainMenu() {
        this.width = Minecraft.getInstance().getWindow().getScreenWidth();
        this.height = Minecraft.getInstance().getWindow().getScreenHeight();
        this.minecraft = Minecraft.getInstance();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        guiGraphics.setColor(1, 1, 1, 1);
        guiGraphics.blit(getHudResourceLocation("main"), screenWidth / 2-16, screenHeight / 2-64, 0, 0, 32, 32, 32, 32);
    }

    public static MainMenu getInstance() {
        return new MainMenu();
    }
}