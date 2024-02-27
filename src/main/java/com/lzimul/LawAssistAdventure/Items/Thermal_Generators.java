package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class Thermal_Generators extends BlockItem {
    public Thermal_Generators() {
        super(BlockRegister.Thermal_Generators.get(), new Item.Properties());
    }
}
