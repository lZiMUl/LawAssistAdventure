package com.lzimul.LawAssistAdventure.client.hud;

import com.lzimul.LawAssistAdventure.Config;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.getResourceLocation;
import static com.lzimul.LawAssistAdventure.item.PearFlowerGunItem.ammunitionHelper;

public class PearFlowerGunHud implements IGuiOverlay {
    private final Minecraft minecraft;
    private final int imageWidth;
    private final int imageHeight;

    public PearFlowerGunHud() {
        this.minecraft = Minecraft.getInstance();
        this.imageWidth = 1080 / 10;
        this.imageHeight = 607 / 10;
    }

    public static PearFlowerGunHud getInstance() {
        return new PearFlowerGunHud();
    }

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        int positionZ = screenWidth - imageWidth;
        int positionY = screenHeight - imageHeight;

        assert minecraft.player != null;
        if (minecraft.player.getMainHandItem().getItem() == ItemRegister.PearFlowerGun.get().asItem()) {
            guiGraphics.setColor(1, 1, 1, 1);
            guiGraphics.blit(getResourceLocation(Config.ResourceType.HUD, "pear_flower_gun"), positionZ, positionY, 0, 0, screenWidth - 10, screenHeight - 10, imageWidth, imageHeight);
            guiGraphics.drawString(this.minecraft.font, String.valueOf(ammunitionHelper.getCurrent()), positionZ + 28, positionY + 28, 0x00ff00);
            guiGraphics.drawString(this.minecraft.font, String.valueOf(ammunitionHelper.getTotal()), positionZ + 60, positionY + 43, 0x00ff00);
        }
    }
}