package com.lzimul.LawAssistAdventure.network;
// TODO 服务器网络同步方法丢失

import net.neoforged.neoforge.network.handling.ClientPayloadContext;

public class ServerNetworkProvider {

    private static final ServerNetworkProvider INSTANCE = new ServerNetworkProvider();

    public static ServerNetworkProvider getInstance() {
        return INSTANCE;
    }

    public void handleData(final NetworkData networkData, final ClientPayloadContext playPayloadContext) {
//        playPayloadContext.channelHandlerContext.isD((player) -> playPayloadContext.channelHandlerContext().connect(() -> {
//            String data = networkData.data();
//            switch (data) {
//                case "server:occupation/Dust":
//                    teleportToWorld(player, DimensionRegister.Dust);
//                    break;
//                case "server:occupation/FallIntoTheVoid":
//                    teleportToWorld(player, DimensionRegister.FallIntoTheVoid);
//                    break;
//                case "server:occupation/FinalWing":
//                    teleportToWorld(player, DimensionRegister.FinalWing);
//                    break;
//                case "server:occupation/RemnantDawn":
//                    teleportToWorld(player, DimensionRegister.RemnantDawn);
//                    break;
//                case "server:occupation/Staring":
//                    teleportToWorld(player, DimensionRegister.Staring);
//                    break;
//                case "server:occupation/Dimension":
//                    teleportToWorld(player, DimensionRegister.Overworld);
//                    break;
//                case "server:occupation/TheNether":
//                    teleportToWorld(player, DimensionRegister.TheNether);
//                    break;
//                case "server:occupation/TheEnd":
//                    teleportToWorld(player, DimensionRegister.TheEnd);
//                    break;
//                case "server:keyBoard/R":
//                    switch (player.getMainHandItem().getItem().getDescriptionId()) {
//                        case "item.law_assist_adventure.ak47":
//                            Ak47Item.reload(player);
//                            break;
//                        case "item.law_assist_adventure.glock19":
//                            Glock19Item.reload(player);
//                            break;
//                        case "item.law_assist_adventure.pear_flower_gun":
//                            PearFlowerGunItem.reload(player);
//                            break;
//                        case "item.law_assist_adventure.harquebus":
//                            HarquebusItem.reload(player);
//                            break;
//                    }
//                    break;
//                case "server:keyBoard/C":
//                    if (player.getMainHandItem().getItem().getDescriptionId().equals("item.law_assist_adventure.glock19")) {
//                        if (Glock19Item.fireNum == 1) {
//                            Glock19Item.fireNum = 3;
//                        } else {
//                            Glock19Item.fireNum = 1;
//                        }
//                    }
//                    break;
//            }
//        }).exceptionally(e -> {
//            playPayloadContext.packetHandler().disconnect(Component.literal("network.law_assist_adventure." + e.getMessage()));
//            return null;
//        }));
    }
}