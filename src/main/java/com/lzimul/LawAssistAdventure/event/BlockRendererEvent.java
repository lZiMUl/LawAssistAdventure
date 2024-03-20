package com.lzimul.LawAssistAdventure.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRendererEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) throws IllegalAccessException {
//        for (Field field : BlockRegister.class.getDeclaredFields()) {
//            int fieldIndex = field.getModifiers();
//            if (Modifier.isPublic(fieldIndex) && Modifier.isStatic(fieldIndex)) {
//                ItemBlockRenderTypes.setRenderLayer(((DeferredBlock<Block>) field.get(null)).get(), RenderType.translucent());
//            }
//        }
    }
}