package com.lzimul.LawAssistAdventure.client.hud;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class MainMenu implements IGuiOverlay {
    private static final MainMenu hud = new MainMenu();
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(MODID, "textures/gui/hud.png");

    public MainMenu() {
        this.width = Minecraft.getInstance().getWindow().getScreenWidth();
        this.height = Minecraft.getInstance().getWindow().getScreenHeight();
        this.minecraft = Minecraft.getInstance();
    }

    @Override
    public void render(@NotNull ExtendedGui gui, @NotNull GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        assert minecraft.player != null;
        if (minecraft.player.getMainHandItem().getItem()!= ItemRegister.CraftingTable.get())
            return;
        guiGraphics.setColor(1,1,1,1);
        guiGraphics.blit(HUD,screenWidth/2-16,screenHeight/2-64,0,0,32,32,32,32);
    }

    public static MainMenu getInstance() {
        return hud;
    }
}