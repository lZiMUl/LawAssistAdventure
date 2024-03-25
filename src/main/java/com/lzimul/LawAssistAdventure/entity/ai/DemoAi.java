package com.lzimul.LawAssistAdventure.entity.ai;

import com.lzimul.LawAssistAdventure.entity.Demo3Animal;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DemoAi extends Goal {
    public final Demo3Animal demo3Animal;

    public DemoAi(Demo3Animal demo3Animal) {
        this.demo3Animal = demo3Animal;
    }

    @Override
    public boolean canUse() {
        Level level = this.demo3Animal.level();
        if (!level.isClientSide) {
            Player nearestPlayer = level.getNearestPlayer(this.demo3Animal, 10);
            if (nearestPlayer != null) {
                nearestPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 3 * 20, 3));
            }
        }
        return true;
    }
}