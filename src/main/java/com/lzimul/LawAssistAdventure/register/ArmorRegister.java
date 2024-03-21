package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.client.helper.ArmorHelper;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorRegister {
    public static final ArmorHelper ExtremeDangerExplorerHelm = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerHelm.asItem()),
            "extreme_danger_explorer_helm",
            0.25f,
            0.15f
    );
    public static final ArmorHelper ExtremeDangerExplorerBreastplate = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerBreastplate.asItem()),
            "extreme_danger_explorer_breastplate",
            0.25f,
            0.15f
    );
    public static final ArmorHelper ExtremeDangerExplorerPants = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants.asItem()),
            "extreme_danger_explorer_pants",
            0.25f,
            0.15f
    );
    public static final ArmorHelper ExtremeDangerExplorerShoes = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.ExtremeDangerExplorerPants.asItem()),
            "extreme_danger_explorer_shoes",
            0.25f,
            0.15f
    );
    public static final ArmorHelper DefendTheBall = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.DefendTheBall.asItem()),
            "defend_the_ball",
            0.25f,
            0.15f
    );
    public static final ArmorHelper Parachute = new ArmorHelper(
            new int[]{500, 1200, 600, 400},
            new int[]{11, 16, 15, 13},
            20,
            SoundRegister.Demo.get(),
            () -> Ingredient.of(ItemRegister.Parachute.asItem()),
            "parachute",
            0.25f,
            0.15f
    );
}
