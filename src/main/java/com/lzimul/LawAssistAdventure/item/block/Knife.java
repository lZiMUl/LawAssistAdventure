package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Knife extends BlockItem {
    public Knife() {
        super(BlockRegister.Knife.get(), new Item.Properties());
    }
}
