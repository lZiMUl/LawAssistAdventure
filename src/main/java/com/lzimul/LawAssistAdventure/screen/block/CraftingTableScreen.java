package com.lzimul.LawAssistAdventure.screen.block;

import com.lzimul.LawAssistAdventure.menu.block.CraftingTableMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class CraftingTableScreen extends AbstractContainerScreen<CraftingTableMenu> {
    //    我启动ba
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(MODID,"textures/gui/crafting_table.png");
    public CraftingTableScreen(CraftingTableMenu craftingTableMenu, Inventory inventory, Component component) {
        super(craftingTableMenu, inventory, component);
    }
    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE,x, y, 0, 0, imageWidth, imageHeight);
    }
    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        // 不知道 复制别人的pGuiGraphics本身就是拿来画图形的pGuiGraphics.blit();画图片pGuiGraphics.drawString()写字

        super.renderBackground(pGuiGraphics,pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics,pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
