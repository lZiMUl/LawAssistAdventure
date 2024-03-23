package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class WasherItem extends BlockItem {
    public WasherItem() {
        super(BlockRegister.Washer.get(), new Item.Properties());
    }
}