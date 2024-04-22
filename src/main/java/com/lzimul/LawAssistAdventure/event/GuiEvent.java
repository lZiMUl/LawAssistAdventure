package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.hud.*;
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
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "main"), MainHud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "ak47"), Ak47Hud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "glock19"), Glock19Hud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "pear_flower_gun"), PearFlowerGunHud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID, "harquebus"), HarquebusHud.getInstance());
    }
}
