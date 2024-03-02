package com.lzimul.LawAssistAdventure.generator;

import com.lzimul.LawAssistAdventure.register.BlockRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(BlockRegister.CopperOre.get(), cubeAll(BlockRegister.CopperOre.get()));
        this.proBlock(BlockRegister.CraftingTable.get());
    }

    private void proBlock(Block block) {
        var blockOn = models().cubeAll("block_on", new ResourceLocation(MODID, ModelProvider.BLOCK_FOLDER + "/" + block.getName()));
        var blockOff = models().cubeAll("block_off", new ResourceLocation(MODID, ModelProvider.BLOCK_FOLDER + "/" + block.getName()));
//        getVariantBuilder(block).partialState().with(LampBlock.LIT, true)
//                .modelForState().modelFile(blockOn).addModel()
//                .partialState().with(false)
//                .modelForState().modelFile(blockOff).addModel();
        simpleBlockItem(block, blockOff);

    }
}
