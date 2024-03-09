package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.menu.block.*;
import com.lzimul.LawAssistAdventure.menu.item.TeleporterMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class MenuRegister {
    public static final DeferredRegister<MenuType<?>> Menu = DeferredRegister.create(Registries.MENU, MODID);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenu(String name, IContainerFactory<T> factory) {
        return Menu.register(name, () -> new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void register(IEventBus modEventBus) {
        Menu.register(modEventBus);
    }

    public static final DeferredHolder<MenuType<?>, MenuType<CraftingTableMenu>> CraftingTableMenu = registerMenu("crafting_table_menu", CraftingTableMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<FluidFuelGeneratorMenu>> FluidFuelGeneratorMenu = registerMenu("fluid_fuel_generator_menu", FluidFuelGeneratorMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ThermalGeneratorMenu>> ThermalGeneratorMenu = registerMenu("thermal_generator_menu", ThermalGeneratorMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<WasherMenu>> WasherMenu = registerMenu("washer_menu", WasherMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<SolarPanelGeneratorMenu>> SolarPanelGeneratorMenu = registerMenu("solar_panel_generator_menu", SolarPanelGeneratorMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<TeleporterMenu>> TeleporterMenu = registerMenu("teleporter", TeleporterMenu::new);


}
