//package com.lzimul.LawAssistAdventure;
//
//import net.minecraft.core.registries.Registries;
//import net.minecraft.world.flag.FeatureFlagSet;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.MenuType;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.network.IContainerFactory;
//import net.neoforged.neoforge.registries.DeferredRegister;
//
//import static com.lzimul.LawAssistAdventure.Config.MODID;
//
//public class ScreenRegister {
//    public static final DeferredRegister<MenuType<?>> MENU_REGISTER = DeferredRegister.create(Registries.MENU, MODID);
//
//        public static final DeferredRegister<MenuType<AbstractContainerMenu>> Teleporter = register("teleporter", TeleporterMenu::new);
//    private static <T extends AbstractContainerMenu> MenuType<T> register(String name, IContainerFactory<T> menuType) {
//        return MENU_REGISTER.register(name, () -> new MenuType(menuType, FeatureFlagSet.of()).create(1, menuType));
//    }
//    public static void register(IEventBus modEventBus) {
//        MENU_REGISTER.register(modEventBus);
//    }
//}
