package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class FluidFuelGenerator extends BlockItem {
    public FluidFuelGenerator() {
        super(BlockRegister.FluidFuelGenerator.get(), new Item.Properties());
    }
}
