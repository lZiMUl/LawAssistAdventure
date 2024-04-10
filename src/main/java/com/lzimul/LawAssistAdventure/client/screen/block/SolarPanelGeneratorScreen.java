package com.lzimul.LawAssistAdventure.client.screen.block;

import com.lzimul.LawAssistAdventure.Config;
import com.lzimul.LawAssistAdventure.client.menu.block.SolarPanelGeneratorMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.getResourceLocation;

public class SolarPanelGeneratorScreen extends AbstractContainerScreen<SolarPanelGeneratorMenu> {
    public SolarPanelGeneratorScreen(SolarPanelGeneratorMenu solarPanelGenerator, Inventory inventory, Component component) {
        super(solarPanelGenerator, inventory, component);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(getResourceLocation(Config.Mode.BLOCK, "solar_panel_generator"), x, y, 0, 0, imageWidth, imageHeight);
    }

    public void renderProgressArrow(@NotNull GuiGraphics guiGraphics, int x, int y) {
//        if (super.menu.isCrafting()) {
        guiGraphics.blit(getResourceLocation(Config.Mode.HUD, "arrow"), x, y, 0, 0, 16, 16);
//        }
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
