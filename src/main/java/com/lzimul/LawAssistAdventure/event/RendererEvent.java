package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.client.hud.*;
import com.lzimul.LawAssistAdventure.client.key.KeyBinding;
import com.lzimul.LawAssistAdventure.client.renderer.entity.*;
import com.lzimul.LawAssistAdventure.client.model.entity.*;
import com.lzimul.LawAssistAdventure.register.EntityRegister;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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

    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult modifyBakingResult){
//        for(BlockState blockState: ModBlocks.HIDDEN_BLOCK.get().getStateDefinition().getPossibleStates()){
//            ModelResourceLocation modelResourceLocation = BlockModelShaper.stateToModelLocation(blockState);
//            BakedModel existingModel = event.getModels().get(modelResourceLocation);
//            if(existingModel==null){
//                throw new RuntimeException("Did not find Obsidian Hidden in registry");
//            }else if (existingModel instanceof HiddenBlockModel) {
//                throw new RuntimeException("Tried to replaceObsidian Hidden twice");
//            }else {
//                HiddenBlockModel obsidianHiddenBlockModel = new HiddenBlockModel(existingModel);
//                event.getModels().put(modelResourceLocation, obsidianHiddenBlockModel);
//            }
//        }
//
//        // wrench item model
//        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
//        ModelResourceLocation location = new ModelResourceLocation(BuiltInRegistries.ITEM.getKey(ModItems.WRENCH_ITEM.get()), "inventory");
//        BakedModel existingModel = modelRegistry.get(location);
//        if (existingModel == null) {
//            throw new RuntimeException("Did not find Obsidian Hidden in registry");
//        } else if (existingModel instanceof WrenchBakeModel) {
//            throw new RuntimeException("Tried to replaceObsidian Hidden twice");
//        } else {
//            WrenchBakeModel obsidianWrenchBakedModel = new WrenchBakeModel(existingModel);
//            event.getModels().put(location, obsidianWrenchBakedModel);
//        }
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent registerGuiOverlaysEvent) {
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID,"main_hud"), MainHud.getInstance());
        registerGuiOverlaysEvent.registerAboveAll(new ResourceLocation(MODID,"gun_hud"), GunHud.getInstance());
    }


    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.DRINKING_KEY);
    }
}
