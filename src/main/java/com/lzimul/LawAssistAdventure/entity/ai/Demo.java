package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.stream.Stream;

public class Demo implements EntityAccess {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public @NotNull UUID getUUID() {
        return UUIDUtil.createOfflinePlayerUUID("LawAssistAdventure");
    }

    @Override
    public @NotNull BlockPos blockPosition() {
        return new BlockPos(0, 0, 0);
    }

    @Override
    public @NotNull AABB getBoundingBox() {
        return null;
    }

    @Override
    public void setLevelCallback(@NotNull EntityInLevelCallback p_156797_) {

    }

    @Override
    public @NotNull Stream<? extends EntityAccess> getSelfAndPassengers() {
        return null;
    }

    @Override
    public @NotNull Stream<? extends EntityAccess> getPassengersAndSelf() {
        return null;
    }

    @Override
    public void setRemoved(Entity.@NotNull RemovalReason p_156798_) {

    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    public boolean isAlwaysTicking() {
        return false;
    }
}
