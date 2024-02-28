package com.lzimul.LawAssistAdventure.Items.Blocks;

import com.lzimul.LawAssistAdventure.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class PowerWire extends BlockItem {
    public PowerWire() {
        super(BlockRegister.PowerWire.get(), new Item.Properties());
    }
}
