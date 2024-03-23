package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class TinOreItem extends BlockItem {
    public TinOreItem() {
        super(BlockRegister.TinOre.get(), new Item.Properties());
    }
}
