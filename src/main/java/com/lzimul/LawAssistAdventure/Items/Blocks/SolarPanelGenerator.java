package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class SolarPanelGenerator extends BlockItem {
    public SolarPanelGenerator() {
        super(BlockRegister.SolarPanelGenerator.get(), new Item.Properties());
    }
}