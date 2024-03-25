package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

import static com.lzimul.LawAssistAdventure.Config.isDistanceExceeded;

public class MoveToPlayerAi extends MoveToBlockGoal {
    private final PathfinderMob pathfinderMob;
    private final double speedModifier;
    private final int searchRange;

    public MoveToPlayerAi(PathfinderMob pathfinderMob, double speedModifier, int searchRange) {
        super(pathfinderMob, speedModifier, searchRange);
        this.pathfinderMob = pathfinderMob;
        this.speedModifier = speedModifier;
        this.searchRange = searchRange;
        super.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }

    @Override
    public void tick() {
        Player target = this.pathfinderMob.level().getNearestPlayer(this.pathfinderMob, this.searchRange);
        if (target != null && target.isAlive()) {
            if (isDistanceExceeded(this.pathfinderMob, target, 8)) {
                this.pathfinderMob.lookAt(target, 30.0F, 30.0F);
                this.pathfinderMob.getNavigation().moveTo(target, this.speedModifier);
            } else if (this.pathfinderMob.getNavigation().isDone() && !this.pathfinderMob.getNavigation().isInProgress()) {
                super.stop();
                this.pathfinderMob.getNavigation().stop();
            }
        } else {
            super.stop();
            this.pathfinderMob.getNavigation().stop();
        }
        super.tick();
    }

    @Override
    protected boolean isValidTarget(@NotNull LevelReader p_25619_, @NotNull BlockPos p_25620_) {
        return true;
    }
}
