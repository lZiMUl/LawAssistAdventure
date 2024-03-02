package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberWood extends BlockItem {
    public RubberWood() {
        super(BlockRegister.RubberWood.get(), new Item.Properties());
    }
}
