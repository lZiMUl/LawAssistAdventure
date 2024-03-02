package com.lzimul.LawAssistAdventure.generator;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add(BlockRegister.CraftingTable.get(), "Crafting Table");
    }
}
