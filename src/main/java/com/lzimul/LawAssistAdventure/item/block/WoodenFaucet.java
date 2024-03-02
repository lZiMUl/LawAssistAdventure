package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class WoodenFaucet extends BlockItem {
    public WoodenFaucet() {
        super(BlockRegister.WoodenFaucet.get(), new Item.Properties());
    }
}
