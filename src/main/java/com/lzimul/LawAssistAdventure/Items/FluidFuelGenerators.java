package com.lzimul.LawAssistAdventure.Items;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class FluidFuelGenerators extends BlockItem {
    public FluidFuelGenerators() {
        super(BlockRegister.FluidFuelGenerators.get(), new Item.Properties());
    }
}
