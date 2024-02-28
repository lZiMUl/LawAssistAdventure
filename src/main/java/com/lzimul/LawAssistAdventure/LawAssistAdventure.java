package com.lzimul.LawAssistAdventure;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.lzimul.LawAssistAdventure.Config.LOGGER;
import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod(MODID)
public class LawAssistAdventure extends ItemGroup {
    public LawAssistAdventure(IEventBus modEventBus) {
        ItemGroup.register(modEventBus);
        ItemRegister.register(modEventBus);
        BlockRegister.register(modEventBus);
        Sounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Hello from server setup");
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) throws IllegalAccessException {
            LOGGER.info("Hello from client setup");
            for (Field field : BlockRegister.class.getDeclaredFields()) {
                int fieldIndex = field.getModifiers();
                if (Modifier.isPublic(fieldIndex) && Modifier.isStatic(fieldIndex)) {
                    ItemBlockRenderTypes.setRenderLayer(((DeferredBlock<Block>) field.get(null)).get(), RenderType.cutout());
                }
            }
        }
    }
}
