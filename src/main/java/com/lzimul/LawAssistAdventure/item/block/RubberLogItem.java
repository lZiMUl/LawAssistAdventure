package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberLogItem extends BlockItem {
    public RubberLogItem() {
        super(BlockRegister.RubberLog.get(), new Item.Properties());
    }
}
