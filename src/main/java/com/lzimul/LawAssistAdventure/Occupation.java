package com.lzimul.LawAssistAdventure;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.function.Supplier;

public class Occupation<T> {
    private static String occupation = "no_occupation";

    public Occupation(Player player, Supplier<T> occupation) {
        String name = occupation.get().getClass().getName();
        switch (name.substring(name.lastIndexOf(".") + 1)) {
            case "Dust":
                player.sendSystemMessage(Occupation.showMessage("dust"));
                break;
            case "FallIntoTheVoid":
                player.sendSystemMessage(Occupation.showMessage("fall_into_the_void"));
                break;
            case "FinalWing":
                player.sendSystemMessage(Occupation.showMessage("final_wing"));
                break;
            case "RemnantDawn":
                player.sendSystemMessage(Occupation.showMessage("remnant_dawn"));
                break;
            case "Staring":
                player.sendSystemMessage(Occupation.showMessage("staring"));
                break;
            default:
                player.sendSystemMessage(Occupation.showMessage("no_occupation"));
                break;
        }
    }

    public static boolean isOccupation(String occupation) {
        return Objects.equals(Occupation.occupation, occupation);
    }

    private static MutableComponent showMessage(String occupation) {
        if (!Occupation.occupation.equals(occupation)) {
            Occupation.occupation = occupation;
            return Component.translatable("occupation.law_assist_adventure." + occupation, "[职业已更改]");
        }
        return Component.translatable("occupation.law_assist_adventure." + occupation, "[职业未更改]");
    }
}
