package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemGroup {
    private static final DeferredRegister<CreativeModeTab> CreativeTab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    DeferredHolder<CreativeModeTab, CreativeModeTab> block = CreativeTab.register("item_group.lzimul.law_assist_adventure.blocks", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BlockRegister.CraftingTable.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.blocks"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CraftingTable.get());
                output.accept(ItemRegister.ThermalGenerator.get());
                output.accept(ItemRegister.SolarPanelGenerator.get());
                output.accept(ItemRegister.FluidFuelGenerator.get());
                output.accept(ItemRegister.PowerStorageBox1.get());
                output.accept(ItemRegister.PowerStorageBox2.get());
                output.accept(ItemRegister.PowerStorageBox3.get());
                output.accept(ItemRegister.PowerStorageBox4.get());
                output.accept(ItemRegister.PowerStorageBox5.get());
                output.accept(ItemRegister.IndustrialSmeltingFurnaces.get());
                output.accept(ItemRegister.Washer.get());
                output.accept(ItemRegister.Mill.get());
                output.accept(ItemRegister.Rollers.get());
                output.accept(ItemRegister.Knife.get());
                output.accept(ItemRegister.PowerWire.get());
                output.accept(ItemRegister.Oven.get());
                output.accept(ItemRegister.Saucepan.get());
                output.accept(ItemRegister.RubberLog.get());
                output.accept(ItemRegister.RubberPlanks.get());
                output.accept(ItemRegister.RubberLeaves.get());
                output.accept(ItemRegister.Cask.get());
                output.accept(ItemRegister.WoodenFaucet.get());
                output.accept(ItemRegister.CopperOre.get());
                output.accept(ItemRegister.TinOre.get());
            }).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> item = CreativeTab.register("item_group.lzimul.law_assist_adventure.items", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.CopperIngot.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.items"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CopperIngot.get());
                output.accept(ItemRegister.SteelIngot.get());
                output.accept(ItemRegister.TinIngot.get());
                output.accept(ItemRegister.GoldWire.get());
                output.accept(ItemRegister.CopperWire.get());
                output.accept(ItemRegister.TinWire.get());
                output.accept(ItemRegister.IronPlates.get());
                output.accept(ItemRegister.GoldPlates.get());
                output.accept(ItemRegister.CopperPlates.get());
                output.accept(ItemRegister.SteelPlates.get());
                output.accept(ItemRegister.TinPlates.get());
                output.accept(ItemRegister.CircuitBoards1.get());
                output.accept(ItemRegister.CircuitBoards2.get());
                output.accept(ItemRegister.CircuitBoards3.get());
                output.accept(ItemRegister.CircuitBoardsBase.get());
                output.accept(ItemRegister.Teleporter.get());
                /*
                 * TODO 测试
                 */
                output.accept(ItemRegister.NoOccupation.get());
                output.accept(ItemRegister.Dust.get());
                output.accept(ItemRegister.FallIntoTheVoid.get());
                output.accept(ItemRegister.FinalWing.get());
                output.accept(ItemRegister.RemnantDawn.get());
                output.accept(ItemRegister.Staring.get());
            }).withTabsBefore(block.getId()).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> armor = CreativeTab.register("item_group.lzimul.law_assist_adventure.armors", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.ExtremeDangerExplorerHelm.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.armors"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.ExtremeDangerExplorerHelm.get());
                output.accept(ItemRegister.ExtremeDangerExplorerBreastplate.get());
                output.accept(ItemRegister.ExtremeDangerExplorerPants.get());
                output.accept(ItemRegister.ExtremeDangerExplorerShoes.get());
                output.accept(ItemRegister.DefendTheBall.get());
                output.accept(ItemRegister.Parachute.get());
                output.accept(ItemRegister.Hatchet.get());
                output.accept(ItemRegister.Glock19.get());
                output.accept(ItemRegister.Bullet.get());
                output.accept(ItemRegister.BulletBox.get());
            }).withTabsBefore(item.getId()).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> experience = CreativeTab.register("item_group.lzimul.law_assist_adventure.experiences", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.ResearcherHandbook.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.experiences"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.ResearcherHandbook.get());
                output.accept(ItemRegister.ResearcherNote.get());
                output.accept(ItemRegister.ResearcherNoteTampered.get());
                output.accept(ItemRegister.ResearcherNoteCorrupted.get());
            }).withTabsBefore(armor.getId()).build());

    public static void register(IEventBus modEventBus) {
        CreativeTab.register(modEventBus);
    }
}
