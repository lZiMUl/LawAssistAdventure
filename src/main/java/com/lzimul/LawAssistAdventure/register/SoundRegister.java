package com.lzimul.LawAssistAdventure.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class SoundRegister {
    public static final DeferredRegister<SoundEvent> Sound = DeferredRegister.create(Registries.SOUND_EVENT, MODID);
    public static final Supplier<SoundEvent> Demo = registerSound("demo");
    public static final Supplier<SoundEvent> AK47Fire = registerSound("ak47_fire");
    public static final Supplier<SoundEvent> AK47Reload = registerSound("ak47_reload");
    public static final Supplier<SoundEvent> Glock19Fire = registerSound("glock19_fire");
    public static final Supplier<SoundEvent> Glock19Reload = registerSound("glock19_reload");

    private static Supplier<SoundEvent> registerSound(String name) {
        return Sound.register("sound." + name, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(MODID, "sound." + name), 16.0F));
    }

    public static void register(IEventBus eventBus) {
        Sound.register(eventBus);
    }

}
