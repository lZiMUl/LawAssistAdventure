package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Cask extends BlockItem {
    public Cask() {
        super(BlockRegister.Cask.get(), new Item.Properties());
    }
}