package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class CraftingTableItem extends BlockItem {
    public CraftingTableItem() {
        super(BlockRegister.CraftingTable.get(), new Item.Properties());
    }
}
