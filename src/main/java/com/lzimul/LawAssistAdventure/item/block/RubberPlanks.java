package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class RubberPlanks extends BlockItem {
    public RubberPlanks() {
        super(BlockRegister.RubberPlanks.get(), new Item.Properties());
    }
}
