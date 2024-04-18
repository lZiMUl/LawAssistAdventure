package com.lzimul.LawAssistAdventure.register;

//import com.lzimul.LawAssistAdventure.client.trigger.DemoTrigger;
//import com.lzimul.LawAssistAdventure.client.trigger.DemoTriggers;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class TriggerRegister {
    private static final DeferredRegister<CriterionTrigger<?>> Trigger = DeferredRegister.create(Registries.TRIGGER_TYPE, MODID);

    public static void register(IEventBus modEventBus) {
        Trigger.register(modEventBus);
    }

//    public static final DeferredRegister<CriterionTrigger<DemoTriggers>> Demo = Trigger.register("demo", DemoTrigger::new);
}
