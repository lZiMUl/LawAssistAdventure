package com.lzimul.LawAssistAdventure.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class DimensionRegister {
    public static final ResourceKey<Level> Overworld = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("overworld"));
    public static final ResourceKey<Level> TheNether = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_nether"));
    public static final ResourceKey<Level> TheEnd = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_end"));
    public static final ResourceKey<Level> FinalWing = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(MODID, "final_wing"));
    public static final ResourceKey<Level> RemnantDawn = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(MODID, "remnant_dawn"));
    public static final ResourceKey<Level> FallIntoTheVoid = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(MODID, "fall_into_the_void"));
    public static final ResourceKey<Level> Dust = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(MODID, "dust"));
    public static final ResourceKey<Level> Staring = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(MODID, "staring"));
}
