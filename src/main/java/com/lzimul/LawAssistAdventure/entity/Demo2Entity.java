package com.lzimul.LawAssistAdventure.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Demo2Entity extends Entity {
    private static final EntityDataAccessor<Integer> entityDataAccessor = SynchedEntityData.defineId(Demo2Entity.class, EntityDataSerializers.INT);

    public Demo2Entity(EntityType<Demo2Entity> entity, Level level) {
        super(entity, level);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(entityDataAccessor, 0);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        this.entityData.set(entityDataAccessor, compoundTag.getInt("counter"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putInt("counter", this.entityData.get(entityDataAccessor));
    }
}
