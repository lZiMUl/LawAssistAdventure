package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class SolarPanelGeneratorItem extends BlockItem {
    public SolarPanelGeneratorItem() {
        super(BlockRegister.SolarPanelGenerator.get(), new Item.Properties());
    }
}
