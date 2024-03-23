package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberLeavesItem extends BlockItem {
    public RubberLeavesItem() {
        super(BlockRegister.RubberLeaves.get(), new Item.Properties());
    }
}
