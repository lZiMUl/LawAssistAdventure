package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraft.world.phys.AABB;

import java.util.UUID;
import java.util.stream.Stream;

public class Demo implements EntityAccess {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public UUID getUUID() {
        return null;
    }

    @Override
    public BlockPos blockPosition() {
        return null;
    }

    @Override
    public AABB getBoundingBox() {
        return null;
    }

    @Override
    public void setLevelCallback(EntityInLevelCallback p_156797_) {

    }

    @Override
    public Stream<? extends EntityAccess> getSelfAndPassengers() {
        return null;
    }

    @Override
    public Stream<? extends EntityAccess> getPassengersAndSelf() {
        return null;
    }

    @Override
    public void setRemoved(Entity.RemovalReason p_156798_) {

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
