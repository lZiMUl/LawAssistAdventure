package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class CopperOre extends BlockItem {
    public CopperOre() {
        super(BlockRegister.CopperOre.get(), new Item.Properties());
    }
}