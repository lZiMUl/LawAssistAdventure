package com.lzimul.LawAssistAdventure.items.blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class WoodenFaucet extends BlockItem {
    public WoodenFaucet() {
        super(BlockRegister.WoodenFaucet.get(), new Item.Properties());
    }
}
