package com.lzimul.LawAssistAdventure.generator;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ItemRegister.CopperOre.get());
        this.magic(gets(ItemRegister.CraftingTable.get()));
    }

    private ResourceLocation gets(Item item) {
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
    }

    private void magic(ResourceLocation resourceLocation) {
        this.getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation("law_assist_adventure:item/"))
                .override().predicate(new ResourceLocation(MODID, "size"), 16)
                .model(new ModelFile.UncheckedModelFile("item/")).end();
    }
}
