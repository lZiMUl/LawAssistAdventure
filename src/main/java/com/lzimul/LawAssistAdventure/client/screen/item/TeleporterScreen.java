package com.lzimul.LawAssistAdventure.client.screen.item;

import com.lzimul.LawAssistAdventure.client.menu.item.TeleporterMenu;
import com.lzimul.LawAssistAdventure.network.DataNetwork;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.getItemResourceLocation;

public class TeleporterScreen extends AbstractContainerScreen<TeleporterMenu> {

    public TeleporterScreen(TeleporterMenu teleporterMenu, Inventory inventory, Component component) {
        super(teleporterMenu, inventory, component);
    }

    @Override
    protected void init() {
        int width = super.width / 2;
        int height = super.height / 2;
        super.addRenderableWidget(new ImageButton(width - width / 3, height - height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("Dust", 0), Component.literal("Dust")));
        super.addRenderableWidget(new ImageButton(width - width / 2, height - height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("FallIntoTheVoid", 1), Component.literal("FallIntoTheVoid")));
        super.addRenderableWidget(new ImageButton(width + width / 2, height - height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("FinalWing", 2), Component.literal("FinalWing")));
        super.addRenderableWidget(new ImageButton(width + width / 3, height - height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("RemnantDawn", 3), Component.literal("RemnantDawn")));
        super.addRenderableWidget(new ImageButton(width - width / 3, height + height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("Staring", 4), Component.literal("Staring")));
        super.addRenderableWidget(new ImageButton(width - width / 2, height + height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("Overworld", 5), Component.literal("Overworld")));
        super.addRenderableWidget(new ImageButton(width + width / 2, height + height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("TheNether", 6), Component.literal("TheNether")));
        super.addRenderableWidget(new ImageButton(width + width / 3, height + height / 2, 15, 15, new WidgetSprites(getItemResourceLocation("glock19"), getItemResourceLocation("glock19")), (button) -> this.send("TheEnd", 7), Component.literal("TheEnd")));
    }

    private void send(String occupation, int id) {
        PacketDistributor.SERVER.noArg().send(new DataNetwork("server:occupation/" + occupation, id));
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
