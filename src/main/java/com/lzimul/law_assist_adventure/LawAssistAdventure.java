package com.lzimul.law_assist_adventure;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.lzimul.law_assist_adventure.Config.LOGGER;
import static com.lzimul.law_assist_adventure.Config.MODID;

@Mod(MODID)
public class LawAssistAdventure extends ItemGroups {
    public LawAssistAdventure(IEventBus modEventBus) {
        super();

        ItemGroups.register(modEventBus);
        Items.register(modEventBus);
        Blocks.register(modEventBus);
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
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Hello from client setup");
            ItemBlockRenderTypes.setRenderLayer(Blocks.Crafting_Table.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Washer.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Thermal_Generators.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Storage_Box_1.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Storage_Box_2.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Storage_Box_3.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Storage_Box_4.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Storage_Box_5.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Solar_Panel_Generator.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Fluid_Fuel_Generators.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Power_Wire.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Copper_Ore.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Tin_Ore.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Wind_Tunnel_Chicken.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Industrial_Smelting_Furnaces.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Oven.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Saucepan.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Rubber_Wood.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Rubber_Leaves.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Cask.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.Wooden_Faucet.get(), RenderType.cutout());
        }
    }
}
