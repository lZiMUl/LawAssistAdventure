package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;

import static com.lzimul.LawAssistAdventure.Config.isDistanceExceeded;

public class AttackPlayerAi extends MeleeAttackGoal {

    public final PathfinderMob pathfinderMob;
    private final int searchRange;
    private final double speedModifier;
    private Player nearestPlayer;

    public AttackPlayerAi(PathfinderMob pathfinderMob, double speedModifier, int searchRange) {
        super(pathfinderMob, speedModifier, true);
        this.pathfinderMob = pathfinderMob;
        this.speedModifier = speedModifier;
        this.searchRange = searchRange;
    }

    @Override
    public boolean canUse() {
        this.nearestPlayer = this.pathfinderMob.level().getNearestPlayer(this.pathfinderMob, this.searchRange);
        return this.nearestPlayer != null && this.nearestPlayer.isAlive();
    }

    @Override
    public void tick() {
        if (isDistanceExceeded(this.pathfinderMob, this.nearestPlayer, 8)) {
            this.pathfinderMob.lookAt(this.nearestPlayer, 30.0F, 30.0F);
            this.pathfinderMob.getNavigation().moveTo(this.nearestPlayer, this.speedModifier);
        }
        LookControl lookControl = this.pathfinderMob.getLookControl();
        lookControl.setLookAt(this.nearestPlayer, 30.0F, 30.0F);
        if (lookControl.isLookingAtTarget()) {
            this.nearestPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, 3, true, true));
        }
    }
}