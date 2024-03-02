package com.lzimul.LawAssistAdventure.network.event;

import com.lzimul.LawAssistAdventure.network.C2_Client_Provider;
import com.lzimul.LawAssistAdventure.network.C2_Server_Provider;
import com.lzimul.LawAssistAdventure.network.NetworkData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkRegister {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar("law_assist_adventure");//如果没调用那边收不到数据的 哦 订阅事件
        registrar.play(NetworkData.ID, NetworkData::new, handler ->
                handler.client(C2_Client_Provider.getInstance()::handleData)//这个数据网络组件代表客户端
                        .server(C2_Server_Provider.getInstance()::handleData)//这个数据网络组件代表服务端
        );
    }
}
