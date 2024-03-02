package com.lzimul.LawAssistAdventure.network;


import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ClientProvider {

    private static final ClientProvider INSTANCE = new ClientProvider();

    public static ClientProvider getInstance() {
        return INSTANCE;
    }

    public void handleData(final NetworkData networkData, final PlayPayloadContext playPayloadContext) {
    }
}
