package com.lzimul.LawAssistAdventure.ees;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class Ammunition {
    private final int limit;
    private Player player;
    private int current;
    private int total;

    public Ammunition(int current, int total, int limit) {
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

    public void reload() {
        int differ = limit - current;
        if (differ > 0) {
            if (total - differ >= 0) {
                this.player.sendSystemMessage(Component.literal("成功补充了 " + differ + " 发弹药。"));
                this.current += differ;
                this.total -= differ;
            } else {
                this.player.sendSystemMessage(Component.literal("成功补充了 " + this.total + " 发弹药。"));
                this.current += this.total;
                this.total = 0;
            }
        } else {
            this.player.sendSystemMessage(Component.literal("库存已满，无法继续补充弹药。"));
        }
    }

    public void fire(int num) {
        if (this.current > 0) {
            this.current -= num;
            this.player.sendSystemMessage(Component.literal("射击了 " + num + " 发子弹。"));
        } else {
            this.player.sendSystemMessage(Component.literal("弹药不足，无法射击。"));
        }
    }
}