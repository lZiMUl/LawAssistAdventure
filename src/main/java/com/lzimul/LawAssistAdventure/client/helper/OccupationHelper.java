package com.lzimul.LawAssistAdventure.client.helper;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.function.Supplier;

public class OccupationHelper <T> {
    private static String occupation = "no_occupation";

    public OccupationHelper(Player player, Supplier<T> occupation) {
        String name = occupation.get().getClass().getName();
        switch (name.substring(name.lastIndexOf(".") + 1)) {
            case "DustOccupation":
                player.sendSystemMessage(OccupationHelper.showMessage("dust_occupation"));
                break;
            case "FallIntoTheVoidOccupation":
                player.sendSystemMessage(OccupationHelper.showMessage("fall_into_the_void_occupation"));
                break;
            case "FinalWingOccupation":
                player.sendSystemMessage(OccupationHelper.showMessage("final_wing_occupation"));
                break;
            case "RemnantDawnOccupation":
                player.sendSystemMessage(OccupationHelper.showMessage("remnant_dawn_occupation"));
                break;
            case "StaringOccupation":
                player.sendSystemMessage(OccupationHelper.showMessage("staring_occupation"));
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
