package com.lzimul.LawAssistAdventure.occupation;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.function.Supplier;

public class Occupation <T> {
    private static String occupation = "no_occupation";

    public Occupation(Player player, Supplier<T> occupation) {
        String name = occupation.get().getClass().getName();
        String eventName = name.substring(name.lastIndexOf(".") + 1);
        switch (eventName) {
            case "Dust":
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.dust"));
                break;
            case "FallIntoTheVoid":
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.fall_into_the_void"));
                break;
            case "FinalWing":
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.final_wing"));
                break;
            case "RemnantDawn":
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.remnant_dawn"));
                break;
            case "Staring":
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.staring"));
                break;
            default:
                player.sendSystemMessage(to(eventName, "occupation.law_assist_adventure.no_occupation"));
                break;
        }
    }
    private MutableComponent to(String eventName, String l) {
        if (!Occupation.occupation.equals(eventName)) {
            Occupation.occupation = eventName;
            return Component.translatable(l, "[职业已更改]");
        }
        return Component.translatable(l, "[职业未更改]");
    }

    public static boolean isOccupation(String  occupation) {
        return Objects.equals(Occupation.occupation, occupation);
    }
}
