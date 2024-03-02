package com.lzimul.LawAssistAdventure.network;


import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class C2_Client_Provider {

    private static final C2_Client_Provider INSTANCE = new C2_Client_Provider();

    public static C2_Client_Provider getInstance() {
        return INSTANCE;
    }

    public void handleData(final NetworkData networkData, final PlayPayloadContext playPayloadContext) {
    }
}


// 行不行