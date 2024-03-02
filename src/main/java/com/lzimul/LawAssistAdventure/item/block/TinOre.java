package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class TinOre extends BlockItem {
    public TinOre() {
        super(BlockRegister.TinOre.get(), new Item.Properties());
    }
}
