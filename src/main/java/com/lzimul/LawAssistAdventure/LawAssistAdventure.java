package com.lzimul.LawAssistAdventure;

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

import static com.lzimul.LawAssistAdventure.Config.LOGGER;
import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod(MODID)
public class LawAssistAdventure extends ItemGroup {
    public LawAssistAdventure(IEventBus modEventBus) {
        super();

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
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Hello from client setup");
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Crafting_Table.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Washer.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Thermal_Generators.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Storage_Box_1.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Storage_Box_2.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Storage_Box_3.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Storage_Box_4.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Storage_Box_5.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Solar_Panel_Generator.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Fluid_Fuel_Generators.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Power_Wire.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Copper_Ore.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Tin_Ore.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Wind_Tunnel_Chicken.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Industrial_Smelting_Furnaces.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Oven.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Saucepan.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Rubber_Wood.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Rubber_Leaves.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Cask.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.Wooden_Faucet.get(), RenderType.cutout());
        }
    }
}
