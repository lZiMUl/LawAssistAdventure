package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Oven extends BlockItem {
    public Oven() {
        super(BlockRegister.Oven.get(), new Item.Properties());
    }
}
