package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.entity.Demo3Animal;
import com.lzimul.LawAssistAdventure.register.EntityRegister;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvent {

    @SubscribeEvent
    public static void setupAttributes(EntityAttributeCreationEvent entityAttributeCreationEvent) {
        entityAttributeCreationEvent.put(EntityRegister.DEMO3.get(), Demo3Animal.createAttributes().build());
    }
}
