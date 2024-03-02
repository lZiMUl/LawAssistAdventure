package com.lzimul.LawAssistAdventure.network;

import com.lzimul.LawAssistAdventure.block.CraftingTable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ServerProvider {

    private static final ServerProvider INSTANCE = new ServerProvider();

    public static ServerProvider getInstance() {
        return INSTANCE;
    }


    public void handleData(final NetworkData networkData, final PlayPayloadContext playPayloadContext) {
        try {
            playPayloadContext.player().ifPresent(player -> {
                playPayloadContext.workHandler().submitAsync(() -> {
                    String data = networkData.data();
                    player.sendSystemMessage(Component.literal("我从服务端得到了这个数据:" + data));
                    switch (data) {
                        case "server:menu/CraftingTable": {
//                            if (this.isClient(playPayloadContext)) {

//                           }
                        }
                        break;
                        case "server:menu/114514": {
                            player.sendSystemMessage(Component.literal("114514"));
                        }
                        break;
                        default: {
                            playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure.failed2"));
                        }
                    }
                }).exceptionally(e -> {
                    playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure.failed1"));
                    return null;
                });
            });
        } catch (Exception ignored) {
        }
    }

    private boolean isClient(PlayPayloadContext playPayloadContext) {
        return playPayloadContext.player().isPresent()
                && playPayloadContext.level().isPresent()
                && playPayloadContext.level().get() instanceof ClientLevel;
    }


}
