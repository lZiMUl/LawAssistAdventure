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
    private final int screenWidth;
    private final int screemHeight;
    private final int imageWidth;
    private final int imageHeight;

    public GunHud() {
        this.minecraft = Minecraft.getInstance();
        this.screenWidth = Minecraft.getInstance().getWindow().getScreenWidth();
        this.screemHeight = Minecraft.getInstance().getWindow().getScreenHeight();
        this.imageWidth = screenWidth - 1080;
        this.imageHeight = screemHeight - 607;
        assert Minecraft.getInstance().level != null;
        Objects.requireNonNull(Minecraft.getInstance().level.players().get(0)).sendSystemMessage(Component.literal("[" + screenWidth + ", " + screemHeight + "] | [" + imageWidth + "," + imageHeight + "]"));
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