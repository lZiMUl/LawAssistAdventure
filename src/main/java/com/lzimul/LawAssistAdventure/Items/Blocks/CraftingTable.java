package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class CraftingTable extends BlockItem {
    public CraftingTable() {
        super(BlockRegister.CraftingTable.get(), new Item.Properties());
    }
}
