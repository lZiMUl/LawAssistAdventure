package com.lzimul.LawAssistAdventure.items.blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Saucepan extends BlockItem {
    public Saucepan() {
        super(BlockRegister.Saucepan.get(), new Item.Properties());
    }
}