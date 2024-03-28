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
            .icon(() -> new ItemStack(BlockRegister.CraftingTable.get().asItem()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.blocks"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CraftingTable.get().asItem());
                output.accept(ItemRegister.ThermalGenerator.get().asItem());
                output.accept(ItemRegister.SolarPanelGenerator.get().asItem());
                output.accept(ItemRegister.FluidFuelGenerator.get().asItem());
                output.accept(ItemRegister.PowerStorageBox1.get().asItem());
                output.accept(ItemRegister.PowerStorageBox2.get().asItem());
                output.accept(ItemRegister.PowerStorageBox3.get().asItem());
                output.accept(ItemRegister.PowerStorageBox4.get().asItem());
                output.accept(ItemRegister.PowerStorageBox5.get().asItem());
                output.accept(ItemRegister.IndustrialSmeltingFurnaces.get().asItem());
                output.accept(ItemRegister.Washer.get().asItem());
                output.accept(ItemRegister.Mill.get().asItem());
                output.accept(ItemRegister.Rollers.get().asItem());
                output.accept(ItemRegister.Knife.get().asItem());
                output.accept(ItemRegister.PowerWire.get().asItem());
                output.accept(ItemRegister.Oven.get().asItem());
                output.accept(ItemRegister.Saucepan.get().asItem());
                output.accept(ItemRegister.RubberLog.get().asItem());
                output.accept(ItemRegister.RubberPlanks.get().asItem());
                output.accept(ItemRegister.RubberLeaves.get().asItem());
                output.accept(ItemRegister.Cask.get().asItem());
                output.accept(ItemRegister.WoodenFaucet.get().asItem());
                output.accept(ItemRegister.CopperOre.get().asItem());
                output.accept(ItemRegister.TinOre.get().asItem());
            }).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> item = CreativeTab.register("item_group.lzimul.law_assist_adventure.items", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.CopperIngot.get().asItem()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.items"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CopperIngot.get().asItem());
                output.accept(ItemRegister.SteelIngot.get().asItem());
                output.accept(ItemRegister.TinIngot.get().asItem());
                output.accept(ItemRegister.GoldWire.get().asItem());
                output.accept(ItemRegister.CopperWire.get().asItem());
                output.accept(ItemRegister.TinWire.get().asItem());
                output.accept(ItemRegister.IronPlates.get().asItem());
                output.accept(ItemRegister.GoldPlates.get().asItem());
                output.accept(ItemRegister.CopperPlates.get().asItem());
                output.accept(ItemRegister.SteelPlates.get().asItem());
                output.accept(ItemRegister.TinPlates.get().asItem());
                output.accept(ItemRegister.CircuitBoards1.get().asItem());
                output.accept(ItemRegister.CircuitBoards2.get().asItem());
                output.accept(ItemRegister.CircuitBoards3.get().asItem());
                output.accept(ItemRegister.CircuitBoardsBase.get().asItem());
                output.accept(ItemRegister.Teleporter.get().asItem());
                /*
                 * TODO 测试
                 */
                output.accept(ItemRegister.NoOccupation.get().asItem());
                output.accept(ItemRegister.Dust.get().asItem());
                output.accept(ItemRegister.FallIntoTheVoid.get().asItem());
                output.accept(ItemRegister.FinalWing.get().asItem());
                output.accept(ItemRegister.RemnantDawn.get().asItem());
                output.accept(ItemRegister.Staring.get().asItem());
            }).withTabsBefore(block.getId()).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> armor = CreativeTab.register("item_group.lzimul.law_assist_adventure.armors", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.ExtremeDangerExplorerHelm.get().asItem()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.armors"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.ExtremeDangerExplorerHelm.get().asItem());
                output.accept(ItemRegister.ExtremeDangerExplorerBreastplate.get().asItem());
                output.accept(ItemRegister.ExtremeDangerExplorerPants.get().asItem());
                output.accept(ItemRegister.ExtremeDangerExplorerShoes.get().asItem());
                output.accept(ItemRegister.DefendTheBall.get().asItem());
                output.accept(ItemRegister.Parachute.get().asItem());
                output.accept(ItemRegister.Hatchet.get().asItem());
                output.accept(ItemRegister.PearFlowerGun.get().asItem());
                output.accept(ItemRegister.Ak47.get().asItem());
                output.accept(ItemRegister.Glock19.get().asItem());
                output.accept(ItemRegister.Bullet.get().asItem());
                output.accept(ItemRegister.BulletBox.get().asItem());
            }).withTabsBefore(item.getId()).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> experience = CreativeTab.register("item_group.lzimul.law_assist_adventure.experiences", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.ResearcherHandbook.get().asItem()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.experiences"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.ResearcherHandbook.get().asItem());
                output.accept(ItemRegister.ResearcherNote.get().asItem());
                output.accept(ItemRegister.ResearcherNoteTampered.get().asItem());
                output.accept(ItemRegister.ResearcherNoteCorrupted.get().asItem());
            }).withTabsBefore(armor.getId()).build());

    public static void register(IEventBus modEventBus) {
        CreativeTab.register(modEventBus);
    }
}
