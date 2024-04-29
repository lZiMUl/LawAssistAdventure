package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.entity.Demo1Animal;
import com.lzimul.LawAssistAdventure.entity.Demo2Animal;
import com.lzimul.LawAssistAdventure.register.EntityRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityEvent {

    @SubscribeEvent
    public static void setupAttributes(EntityAttributeCreationEvent entityAttributeCreationEvent) {
        entityAttributeCreationEvent.put(EntityRegister.DEMO1.get(), Demo1Animal.createAttributes().build());
        entityAttributeCreationEvent.put(EntityRegister.DEMO2.get(), Demo2Animal.createAttributes().build());
    }
}
