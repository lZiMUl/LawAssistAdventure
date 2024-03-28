package com.lzimul.LawAssistAdventure.client.screen.item;

import com.lzimul.LawAssistAdventure.client.menu.item.TeleporterMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;
import static com.lzimul.LawAssistAdventure.Config.getItemResourceLocation;

public class TeleporterScreen extends AbstractContainerScreen<TeleporterMenu> {
    private final Inventory inventory;

    public TeleporterScreen(TeleporterMenu teleporterMenu, Inventory inventory, Component component) {
        super(teleporterMenu, inventory, component);
        this.inventory = inventory;
    }

    @Override
    protected void init() {
        this.addRenderableWidget(new ImageButton(30,30,30,30, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> {

        }, Component.literal("cookie")));
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        guiGraphics.blit(getItemResourceLocation("teleporter"), 0, 0, 0, 0, width, height, imageWidth, imageHeight);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
