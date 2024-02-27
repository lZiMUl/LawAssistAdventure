package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Solar_Panel_Generator extends BlockItem {
    public Solar_Panel_Generator() {
        super(BlockRegister.Solar_Panel_Generator.get(), new Item.Properties());
    }
}
