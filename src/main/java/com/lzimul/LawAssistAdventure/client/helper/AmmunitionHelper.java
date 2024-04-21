package com.lzimul.LawAssistAdventure.client.helper;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import java.util.function.Consumer;

public class AmmunitionHelper {
    private final int limit;
    private Player player;
    private int current;
    private int total;

    public AmmunitionHelper(int current, int total, int limit) {
        this.current = current;
        this.total = total;
        this.limit = current + limit;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getTotal() {
        return this.total;
    }

    public int getLimit() {
        return this.limit;
    }

    public void add(int num) {
        this.total += num;
    }

    public void reload() {
        int differ = limit - current;
        if (differ > 0) {
            if (total - differ >= 0) {
                this.current += differ;
                this.total -= differ;
            } else {
                this.current += this.total;
                this.total = 0;
            }
        } else {
            this.player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.stock_full"));
        }
    }

    public void fire(int num, Consumer<Integer> callBack) {
        for (int index = 0; index < num; index++) {
            if (this.current > 0) {
                this.current--;
                callBack.accept(index);
            } else {
                this.player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.not_enough"));
                break;
            }
        }
    }
}