package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.screen.block.*;
import com.lzimul.LawAssistAdventure.client.screen.item.TeleporterScreen;
import com.lzimul.LawAssistAdventure.register.MenuRegister;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreenEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenuRegister.CraftingTableMenu.get(), CraftingTableScreen::new);
            MenuScreens.register(MenuRegister.FluidFuelGeneratorMenu.get(), FluidFuelGeneratorScreen::new);
            MenuScreens.register(MenuRegister.ThermalGeneratorMenu.get(), ThermalGeneratorScreen::new);
            MenuScreens.register(MenuRegister.WasherMenu.get(), WasherScreen::new);
            MenuScreens.register(MenuRegister.SolarPanelGeneratorMenu.get(), SolarPanelGeneratorScreen::new);
            MenuScreens.register(MenuRegister.TeleporterMenu.get(), TeleporterScreen::new);
        });
    }
}
