package com.lzimul.LawAssistAdventure;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorRegister {
    public static final ArmorItem Parachute = new ArmorItem(new Armors(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemRegister.Parachute),
            "parachute",
            0.25f,
            0.15f
    ),
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties()
    );
    public static final ArmorItem ExtremeDangerExplorerHelm = new ArmorItem(new Armors(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerHelm),
            "parachute",
            0.25f,
            0.15f
    ),
            ArmorItem.Type.HELMET,
            new Item.Properties()
    );
    ;
    public static final ArmorItem ExtremeDangerExplorerBreastplate = new ArmorItem(new Armors(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerBreastplate),
            "parachute",
            0.25f,
            0.15f
    ),
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties()
    );
    ;
    public static final ArmorItem ExtremeDangerExplorerPants = new ArmorItem(new Armors(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants),
            "parachute",
            0.25f,
            0.15f
    ),
            ArmorItem.Type.LEGGINGS,
            new Item.Properties()
    );
    ;
    public static final ArmorItem ExtremeDangerExplorerShoes = new ArmorItem(new Armors(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants),
            "parachute",
            0.25f,
            0.15f
    ),
            ArmorItem.Type.BOOTS,
            new Item.Properties()
    );
    ;
}
