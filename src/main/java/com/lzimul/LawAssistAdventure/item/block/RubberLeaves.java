package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberLeaves extends BlockItem {
    public RubberLeaves() {
        super(BlockRegister.RubberLeaves.get(), new Item.Properties());
    }
}
