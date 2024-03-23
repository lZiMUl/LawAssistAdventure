package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ThermalGeneratorItem extends BlockItem {
    public ThermalGeneratorItem() {
        super(BlockRegister.ThermalGenerator.get(), new Item.Properties());
    }
}
