package com.lzimul.LawAssistAdventure.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public record NetworkData(String data, int value) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MODID, "data");

    public NetworkData(final FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), friendlyByteBuf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(data);
        friendlyByteBuf.writeInt(value);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }


}
