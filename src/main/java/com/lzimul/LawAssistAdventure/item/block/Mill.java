package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Mill extends BlockItem {
    public Mill() {
        super(BlockRegister.Mill.get(), new Item.Properties());
    }
}
