package com.lzimul.LawAssistAdventure.entity.ai;

import com.lzimul.LawAssistAdventure.entity.Demo1Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DemoAi extends Goal {
    public final Demo1Entity firstAnimal;

    public DemoAi(Demo1Entity firstAnimal) {
        this.firstAnimal = firstAnimal;
    }

    @Override
    public boolean canUse() {
        Level level = this.firstAnimal.level();
        if (!level.isClientSide) {
            Player nearestPlayer = level.getNearestPlayer(this.firstAnimal, 10);
            if (nearestPlayer != null) {
                nearestPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 3 * 20, 3));
            }

        }
        return true;
    }
}
