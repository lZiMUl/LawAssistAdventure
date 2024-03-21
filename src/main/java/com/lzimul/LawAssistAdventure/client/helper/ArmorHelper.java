package com.lzimul.LawAssistAdventure.client.helper;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public class ArmorHelper implements ArmorMaterial {
    public final int[] durabilityForType;
    public final int[] defenseForType;
    public final int enchantmentValue;
    public final SoundEvent equipSound;
    public final Supplier<Ingredient> repairIngredient;
    public final String name;
    public final float toughness;
    public final float knockbackResistance;

    public ArmorHelper(int[] durabilityForType, int[] defenseForType, int enchantmentValue, SoundEvent equipSound, Supplier<Ingredient> repairIngredient, String name, float toughness, float knockbackResistance) {
        this.durabilityForType = durabilityForType;
        this.defenseForType = defenseForType;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return durabilityForType[type.ordinal()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defenseForType[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public @NotNull String getName() {
        return MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
