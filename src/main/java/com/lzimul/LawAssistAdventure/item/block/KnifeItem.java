package com.lzimul.LawAssistAdventure.item.block;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class KnifeItem extends BlockItem {
    public KnifeItem() {
        super(BlockRegister.Knife.get(), new Item.Properties());
    }
}
