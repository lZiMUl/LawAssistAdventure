package com.lzimul.LawAssistAdventure.network;
// TODO 数据流方法丢失

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public record NetworkData(String data, int value) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MODID, "data_network");

    public NetworkData() {
        this("", 0);
    }

    public NetworkData(final FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), friendlyByteBuf.readInt());
    }

//    @Override
//    public void write(FriendlyByteBuf friendlyByteBuf) {
//        friendlyByteBuf.writeUtf(data);
//        friendlyByteBuf.writeInt(value);
//    }
//
//    @Override
//    public @NotNull ResourceLocation id() {
//        return ID;
//    }

//    @Override
//    public void encode(B p_320490_, CustomPacketPayload customPacketPayload) {
//        customPacketPayload.writeUtf(data);
//        friendlyByteBuf.writeInt(value);
//    }
//
//    @Override
//    public void decode(B p_320490_, CustomPacketPayload customPacketPayload) {
//        data = friendlyByteBuf.readUtf();
//        value = friendlyByteBuf.readInt();
//    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return null;
    }
}
