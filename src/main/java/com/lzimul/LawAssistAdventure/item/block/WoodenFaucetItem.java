package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class WoodenFaucetItem extends BlockItem {
    public WoodenFaucetItem() {
        super(BlockRegister.WoodenFaucet.get(), new Item.Properties());
    }
}
