package com.lzimul.LawAssistAdventure.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class Demo<T extends Entity> extends Entity {
    private final T parent;
    public Demo(T parent) {
        super(parent.getType(), parent.level());
        this.parent = parent;
    }

    public T getParent() {
        return parent;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag p_20139_) {

    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }
}
