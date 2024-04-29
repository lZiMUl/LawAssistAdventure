package com.lzimul.LawAssistAdventure.network;
// TODO 客户端网络同步方法丢失

public class ClientNetworkProvider {

    private static final ClientNetworkProvider INSTANCE = new ClientNetworkProvider();

    public static ClientNetworkProvider getInstance() {
        return INSTANCE;
    }

//    public void handleData(final NetworkData networkData, final ClientPayloadContext clientPayloadContext) {
//        clientPayloadContext.player().ifPresent((player) -> clientPayloadContext.workHandler().submitAsync(() -> {
//            String data = networkData.data();
//            player.sendSystemMessage(Component.literal("我从客户端得到了这个数据:" + data));
//        }));
//    }
}
