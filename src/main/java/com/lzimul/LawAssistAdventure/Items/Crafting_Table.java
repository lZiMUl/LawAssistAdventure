package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Crafting_Table extends BlockItem {
    public Crafting_Table() {
        super(BlockRegister.Crafting_Table.get(), new Item.Properties());
    }
}
