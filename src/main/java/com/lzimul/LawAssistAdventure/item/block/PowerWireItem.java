package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class PowerWireItem extends BlockItem {
    public PowerWireItem() {
        super(BlockRegister.PowerWire.get(), new Item.Properties());
    }
}
