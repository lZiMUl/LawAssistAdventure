package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.hud.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GuiEvent {
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiLayersEvent registerGuiLayersEvent) {
        registerGuiLayersEvent.registerAboveAll(new ResourceLocation(MODID, "main"), MainHud.getInstance());
        registerGuiLayersEvent.registerAboveAll(new ResourceLocation(MODID, "ak47"), Ak47Hud.getInstance());
        registerGuiLayersEvent.registerAboveAll(new ResourceLocation(MODID, "glock19"), Glock19Hud.getInstance());
        registerGuiLayersEvent.registerAboveAll(new ResourceLocation(MODID, "pear_flower_gun"), PearFlowerGunHud.getInstance());
        registerGuiLayersEvent.registerAboveAll(new ResourceLocation(MODID, "harquebus"), HarquebusHud.getInstance());
    }
}
