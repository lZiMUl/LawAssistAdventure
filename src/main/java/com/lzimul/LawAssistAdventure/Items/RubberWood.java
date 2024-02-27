package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberWood extends BlockItem {
    public RubberWood() {
        super(BlockRegister.RubberWood.get(), new Item.Properties());
    }
}
