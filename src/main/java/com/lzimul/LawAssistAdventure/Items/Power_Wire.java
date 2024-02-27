package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Power_Wire extends BlockItem {
    public Power_Wire() {
        super(BlockRegister.Power_Wire.get(), new Item.Properties());
    }
}
