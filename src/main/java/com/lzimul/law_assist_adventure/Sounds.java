package com.lzimul.law_assist_adventure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, Config.MODID);
    public static final Supplier<SoundEvent> Demo = registerSound("sound.demo");
    private static Supplier<SoundEvent> registerSound(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Config.MODID, name), 16.0F));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENT.register(eventBus);
    }

}
