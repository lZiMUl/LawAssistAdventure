package com.lzimul.LawAssistAdventure.entity;

import com.lzimul.LawAssistAdventure.entity.ai.AttackAndFollowAi;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Demo2Animal extends Animal {
    public Demo2Animal(EntityType<Demo2Animal> entity, Level level) {
        super(entity, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 300);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AttackAndFollowAi(this, 1, 30));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return ageableMob;
    }

    @Override
    public boolean isFood(@NotNull ItemStack itemStack) {
        return false;
    }
}
