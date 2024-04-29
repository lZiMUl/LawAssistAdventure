package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo1Model;
import com.lzimul.LawAssistAdventure.client.model.entity.Demo2Model;
import com.lzimul.LawAssistAdventure.client.renderer.entity.Demo1Renderer;
import com.lzimul.LawAssistAdventure.client.renderer.entity.Demo2Renderer;
import com.lzimul.LawAssistAdventure.register.EntityRegister;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererEvent {
    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(EntityRegister.DEMO1.get(), Demo1Renderer::new);
            EntityRenderers.register(EntityRegister.DEMO2.get(), Demo2Renderer::new);
        });
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(Demo1Model.LAYER_LOCATION, Demo1Model::createBodyLayer);
        registerLayerDefinitions.registerLayerDefinition(Demo2Model.LAYER_LOCATION, Demo2Model::createBodyLayer);
    }
}
