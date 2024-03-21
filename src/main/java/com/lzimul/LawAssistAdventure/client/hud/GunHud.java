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

public class GunHud implements IGuiOverlay {
    private final int width;
    private final int height;
    private final Minecraft minecraft;

    public GunHud() {
        this.width = Minecraft.getInstance().getWindow().getScreenWidth();
        this.height = Minecraft.getInstance().getWindow().getScreenHeight();
        this.minecraft = Minecraft.getInstance();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        assert minecraft.player != null;
        if (minecraft.player.getMainHandItem().getItem() == ItemRegister.Glock19.get().asItem()) {
            guiGraphics.setColor(1, 1, 1, 1);
            guiGraphics.blit(getHudResourceLocation("gun_hud"), screenWidth / 2, screenHeight / 2, 0, 0, 50, 50, 1080, 607);
        }
    }

    public static GunHud getInstance() {
        return new GunHud();
    }
}