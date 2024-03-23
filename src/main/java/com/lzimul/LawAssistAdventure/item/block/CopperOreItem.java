package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class CopperOreItem extends BlockItem {
    public CopperOreItem() {
        super(BlockRegister.CopperOre.get(), new Item.Properties());
    }
}
