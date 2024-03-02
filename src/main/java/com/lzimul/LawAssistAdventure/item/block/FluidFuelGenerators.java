package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class FluidFuelGenerators extends BlockItem {
    public FluidFuelGenerators() {
        super(BlockRegister.FluidFuelGenerators.get(), new Item.Properties());
    }
}
