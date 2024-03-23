package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class MillItem extends BlockItem {
    public MillItem() {
        super(BlockRegister.Mill.get(), new Item.Properties());
    }
}
