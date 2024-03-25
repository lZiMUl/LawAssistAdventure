package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class AttackPlayerAi extends MeleeAttackGoal {

    public final PathfinderMob pathfinderMob;
    private final int searchRange;

    public AttackPlayerAi(PathfinderMob pathfinderMob, double speedModifier, int searchRange) {
        super(pathfinderMob, speedModifier, true);
        this.pathfinderMob = pathfinderMob;
        this.searchRange = searchRange;
        super.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));

    }

    @Override
    public void tick() {
        Player nearestPlayer = this.pathfinderMob.level().getNearestPlayer(this.pathfinderMob, this.searchRange);
        if (nearestPlayer != null && nearestPlayer.isAlive()) {
            LookControl lookControl = this.pathfinderMob.getLookControl();
            lookControl.setLookAt(nearestPlayer, 30.0F, 30.0F);
            if (lookControl.isLookingAtTarget()) {
                if (super.canPerformAttack(nearestPlayer)) {
                    super.resetAttackCooldown();
                    this.pathfinderMob.swing(InteractionHand.MAIN_HAND);
                    this.pathfinderMob.doHurtTarget(nearestPlayer);
                }
            }
        }
        super.tick();
    }
}