package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.Config;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SoundRegister {
    public static final DeferredRegister<SoundEvent> Sound = DeferredRegister.create(Registries.SOUND_EVENT, Config.MODID);
    public static final Supplier<SoundEvent> Demo = registerSound("sound.demo");
    private static Supplier<SoundEvent> registerSound(String name) {
        return Sound.register(name, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Config.MODID, name), 16.0F));
    }
    public static void register(IEventBus eventBus) {
        Sound.register(eventBus);
    }

}
