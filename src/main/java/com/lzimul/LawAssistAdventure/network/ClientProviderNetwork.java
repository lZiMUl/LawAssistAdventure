package com.lzimul.LawAssistAdventure.network;


import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ClientProviderNetwork {

    private static final ClientProviderNetwork INSTANCE = new ClientProviderNetwork();

    public static ClientProviderNetwork getInstance() {
        return INSTANCE;
    }

    public void handleData(final DataNetwork networkData, final PlayPayloadContext playPayloadContext) {
        playPayloadContext.player().ifPresent((player) -> playPayloadContext.workHandler().submitAsync(() -> {
            String data = networkData.data();
            player.sendSystemMessage(Component.literal("我从客户端得到了这个数据:" + data));
        }));
    }
}
