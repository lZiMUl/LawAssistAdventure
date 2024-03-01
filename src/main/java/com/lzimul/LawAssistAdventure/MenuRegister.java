package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.menu.block.CraftingTableMenu;
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
    public static final DeferredHolder<MenuType<?>, MenuType<CraftingTableMenu>> CraftingTableMenu = registerMenuType("crafting_table_menu", CraftingTableMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<TeleporterMenu>> TeleporterMenu = registerMenuType("teleporter", TeleporterMenu::new);
    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return Menu.register(name, () -> new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }
    public static void register(IEventBus modEventBus) {
        Menu.register(modEventBus);
    }
}
