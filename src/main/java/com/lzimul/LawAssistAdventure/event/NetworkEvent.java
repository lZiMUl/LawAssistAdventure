package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.network.ClientProvider;
import com.lzimul.LawAssistAdventure.network.NetworkData;
import com.lzimul.LawAssistAdventure.network.ServerProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkEvent {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MODID);
        registrar.play(NetworkData.ID, NetworkData::new, handler -> {
            handler.client(ClientProvider.getInstance()::handleData);
            handler.server(ServerProvider.getInstance()::handleData);
        });
    }
}
