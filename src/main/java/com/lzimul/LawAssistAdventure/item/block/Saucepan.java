package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Saucepan extends BlockItem {
    public Saucepan() {
        super(BlockRegister.Saucepan.get(), new Item.Properties());
    }
}
