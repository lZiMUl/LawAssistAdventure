package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.register.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.lzimul.LawAssistAdventure.Config.LOGGER;
import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod(MODID)
public class LawAssistAdventure extends ItemGroup {
    public LawAssistAdventure(IEventBus eventBus) {
        ItemGroup.register(eventBus);
        ItemRegister.register(eventBus);
        BlockRegister.register(eventBus);
        BlockEntityRegister.register(eventBus);
        EntityRegister.register(eventBus);
        MenuRegister.register(eventBus);
        SoundRegister.register(eventBus);
        TriggerRegister.register(eventBus);

        NeoForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Hello from server setup");
    }
}
