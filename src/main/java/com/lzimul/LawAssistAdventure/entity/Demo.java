package com.lzimul.LawAssistAdventure.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class Demo extends Entity {

    public Demo() {
        super(EntityType.CREEPER, null);
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
}
