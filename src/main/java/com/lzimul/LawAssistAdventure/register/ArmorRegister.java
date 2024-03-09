package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.Armor;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorRegister {
    public static final Armor ExtremeDangerExplorerHelm = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerHelm),
            "extreme_danger_explorer_helm",
            0.25f,
            0.15f
    );
    public static final Armor ExtremeDangerExplorerBreastplate = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerBreastplate),
            "extreme_danger_explorer_breastplate",
            0.25f,
            0.15f
    );
    public static final Armor ExtremeDangerExplorerPants = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants),
            "extreme_danger_explorer_pants",
            0.25f,
            0.15f
    );
    public static final Armor ExtremeDangerExplorerShoes = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants),
            "extreme_danger_explorer_shoes",
            0.25f,
            0.15f
    );
    public static final Armor DefendTheBall = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.DefendTheBall),
            "defend_the_ball",
            0.25f,
            0.15f
    );
    public static final Armor Parachute = new Armor(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.Parachute),
            "parachute",
            0.25f,
            0.15f
    );
}
