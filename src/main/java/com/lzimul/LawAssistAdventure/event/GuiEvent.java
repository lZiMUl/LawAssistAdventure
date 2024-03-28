package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.hud.Ak47Hud;
import com.lzimul.LawAssistAdventure.client.hud.Glock19Hud;
import com.lzimul.LawAssistAdventure.client.hud.MainHud;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GuiEvent {
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent registerGuiOverlaysEvent) {
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "main_hud"), MainHud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "glock19_hud"), Glock19Hud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "ak47_hud"), Ak47Hud.getInstance());
    }
}
