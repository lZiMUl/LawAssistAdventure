package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.network.ClientProviderNetwork;
import com.lzimul.LawAssistAdventure.network.DataNetwork;
import com.lzimul.LawAssistAdventure.network.ServerProviderNetwork;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkEvent {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MODID);
        registrar.play(DataNetwork.ID, DataNetwork::new, handler -> {
            handler.client(ClientProviderNetwork.getInstance()::handleData);
            handler.server(ServerProviderNetwork.getInstance()::handleData);
        });
    }
}
