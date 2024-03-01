package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Rollers extends BlockItem {
    public Rollers() {
        super(BlockRegister.Rollers.get(), new Item.Properties());
    }
}
