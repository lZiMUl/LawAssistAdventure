package com.lzimul.LawAssistAdventure.dimensions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static com.lzimul.LawAssistAdventure.DimensionRegister.placeTeleporterWorld;

public class RemnantDawn implements ITeleporter {
    private final BlockPos pos;

    public RemnantDawn(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public @NotNull Entity placeEntity(@NotNull Entity rawEntity, @NotNull ServerLevel currentWorld, @NotNull ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Entity entity = repositionEntity.apply(false);

        if (!(entity instanceof ServerPlayer player)) {
            return entity;
        }
        LevelChunk chunk = (LevelChunk) destWorld.getChunk(pos);
        Vec3 spawnPos;

//        if (destWorld.dimension().equals(Dimension.REMNANT_DAWN)) {
            spawnPos = placeTeleporterWorld(destWorld, chunk);
//        } else {
//            spawnPos = placeTeleporterOverworld(destWorld, chunk);
//        }

        if (spawnPos == null) {
            return entity;
        }

        player.giveExperienceLevels(0);
        player.teleportTo(spawnPos.x(), spawnPos.y(), spawnPos.z());
        return entity;
    }
}
