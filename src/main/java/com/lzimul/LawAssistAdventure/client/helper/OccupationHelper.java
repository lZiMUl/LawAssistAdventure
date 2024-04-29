package com.lzimul.LawAssistAdventure.client.helper;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.function.Supplier;

public class OccupationHelper<T> {
    public static String occupation = "no_occupation";
    public String occupationName;

    public OccupationHelper(Supplier<T> occupation) {
        this.occupationName = occupation.get().getClass().getName();

    }

    public void use(Player player) {
        switch (occupationName.substring(occupationName.lastIndexOf(".") + 1)) {
            case "Dust":
                player.sendSystemMessage(OccupationHelper.showMessage("dust"));
                break;
            case "FallIntoTheVoid":
                player.sendSystemMessage(OccupationHelper.showMessage("fall_into_the_void"));
                break;
            case "FinalWing":
                player.sendSystemMessage(OccupationHelper.showMessage("final_wing"));
                break;
            case "RemnantDawn":
                player.sendSystemMessage(OccupationHelper.showMessage("remnant_dawn"));
                break;
            case "Staring":
                player.sendSystemMessage(OccupationHelper.showMessage("staring"));
                break;
            default:
                player.sendSystemMessage(OccupationHelper.showMessage("no_occupation"));
                break;
        }
    }

    public static boolean isOccupation(String occupation) {
        return Objects.equals(OccupationHelper.occupation, occupation);
    }

    private static MutableComponent showMessage(String occupation) {
        if (!OccupationHelper.occupation.equals(occupation)) {
            OccupationHelper.occupation = occupation;
            return Component.translatable("occupation.law_assist_adventure." + occupation, "[职业已更改]");
        }
        return Component.translatable("occupation.law_assist_adventure." + occupation, "[职业未更改]");
    }
}
