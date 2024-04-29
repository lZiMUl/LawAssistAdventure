package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.WeaponHelper;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;

public class HatchetItem extends SwordItem {
    public HatchetItem() {
        super(new WeaponHelper(3, 200, 1F, 30, () -> Ingredient.of(ItemRegister.Hatchet.asItem())), new Item.Properties());
    }
}
