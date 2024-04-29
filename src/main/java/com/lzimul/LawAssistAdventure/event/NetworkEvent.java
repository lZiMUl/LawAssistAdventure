package com.lzimul.LawAssistAdventure.event;
// TODO 网络事件丢失

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class NetworkEvent {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MODID);
//        registrar.commonToServer();
//        registrar.play(NetworkData.ID, NetworkData::new, handler -> {
//            handler.client(ClientNetworkProvider.getInstance()::handleData);
//            handler.server(ServerNetworkProvider.getInstance()::handleData);
//        });
    }
}
