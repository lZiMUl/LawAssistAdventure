package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.isDistanceExceeded;

public class FollowPlayerAi extends MoveToBlockGoal {
    private final PathfinderMob pathfinderMob;
    private final double speedModifier;
    private final int searchRange;
    private Player nearestPlayer;

    public FollowPlayerAi(PathfinderMob pathfinderMob, double speedModifier, int searchRange) {
        super(pathfinderMob, speedModifier, searchRange);
        this.pathfinderMob = pathfinderMob;
        this.speedModifier = speedModifier;
        this.searchRange = searchRange;
    }

    @Override
    public boolean canUse() {
        this.nearestPlayer = this.pathfinderMob.level().getNearestPlayer(this.pathfinderMob, this.searchRange);
        return this.nearestPlayer != null && this.nearestPlayer.isAlive() && isDistanceExceeded(this.pathfinderMob, this.nearestPlayer, 8);
    }

    @Override
    public void tick() {
        this.pathfinderMob.lookAt(this.nearestPlayer, 30.0F, 30.0F);
        this.pathfinderMob.getNavigation().moveTo(this.nearestPlayer, this.speedModifier);
    }

    @Override
    protected boolean isValidTarget(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        return true;
    }
}
