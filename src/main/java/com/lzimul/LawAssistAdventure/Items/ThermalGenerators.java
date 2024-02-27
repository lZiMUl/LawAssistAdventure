package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ThermalGenerators extends BlockItem {
    public ThermalGenerators() {
        super(BlockRegister.ThermalGenerators.get(), new Item.Properties());
    }
}
