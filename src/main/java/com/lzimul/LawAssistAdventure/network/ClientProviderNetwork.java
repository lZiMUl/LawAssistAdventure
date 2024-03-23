package com.lzimul.LawAssistAdventure.network;


import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ClientProviderNetwork {

    private static final ClientProviderNetwork INSTANCE = new ClientProviderNetwork();

    public static ClientProviderNetwork getInstance() {
        return INSTANCE;
    }

    public void handleData(final DataNetwork networkData, final PlayPayloadContext playPayloadContext) {
    }
}
