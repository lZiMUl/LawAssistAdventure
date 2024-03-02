package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Washer extends BlockItem {
    public Washer() {
        super(BlockRegister.Washer.get(), new Item.Properties());
    }
}