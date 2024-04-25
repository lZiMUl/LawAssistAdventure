package com.lzimul.LawAssistAdventure.entity.ai;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;

import static com.lzimul.LawAssistAdventure.Config.IsDistanceExceeded;

public class AttackAndFollowAi extends MeleeAttackGoal {

    public final PathfinderMob pathfinderMob;
    private final int searchRange;
    private final double speedModifier;
    PathNavigation pathNavigation;
    LookControl lookControl;
    private Player nearestPlayer;
    private DamageSource tempDamageSource = null;

    public AttackAndFollowAi(PathfinderMob pathfinderMob, double speedModifier, int searchRange) {
        super(pathfinderMob, speedModifier, true);
        this.pathfinderMob = pathfinderMob;
        this.speedModifier = speedModifier;
        this.searchRange = searchRange;
        this.pathNavigation = this.pathfinderMob.getNavigation();
        this.lookControl = this.pathfinderMob.getLookControl();
    }

    @Override
    public boolean canUse() {
        this.nearestPlayer = this.pathfinderMob.level().getNearestPlayer(this.pathfinderMob, this.searchRange);
        return this.nearestPlayer != null && this.nearestPlayer.isAlive();
    }

    @Override
    public void tick() {
        this.lookControl.setLookAt(this.nearestPlayer);
        if (this.pathNavigation.isDone()) {
            this.pathNavigation.stop();
        }
        if (this.tempDamageSource == null) {
            this.tempDamageSource = this.pathfinderMob.getLastDamageSource();
        }
        if (!this.nearestPlayer.isAlive()) {
            this.tempDamageSource = null;
        }
        if (IsDistanceExceeded(this.pathfinderMob, this.nearestPlayer, 8D)) {
            this.pathNavigation.moveTo(this.nearestPlayer, this.speedModifier);
        } else {
            if (this.lookControl.isLookingAtTarget() && this.tempDamageSource != null && isCS(this.nearestPlayer)) {
                if (this.nearestPlayer.hurt(this.tempDamageSource, 3F)) {
                    this.nearestPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, 3, true, true));
                }
            }
        }
    }

    private boolean isCS(Player player) {
        return !(player.isCreative() && player.isSpectator());
    }
}