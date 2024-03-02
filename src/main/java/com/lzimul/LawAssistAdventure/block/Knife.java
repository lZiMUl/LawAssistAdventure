package com.lzimul.LawAssistAdventure.block;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class Knife extends Block {
    public Knife() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!level.isClientSide() && player.isAlive()) {
            switch (player.getMainHandItem().getItem().getDescriptionId()) {
                case "item.minecraft.iron_ingot": {
                    player.drop(new ItemStack(ItemRegister.IronPlates.get()), true);
                }
                break;
                case "item.minecraft.gold_ingot": {
                    player.drop(new ItemStack(ItemRegister.GoldPlates.get()), true);
                }
                break;
                case "item.law_assist_adventure.copper_ingot": {
                    player.drop(new ItemStack(ItemRegister.CopperPlates.get()), true);
                }
                break;
                case "item.law_assist_adventure.steel_ingot": {
                    player.drop(new ItemStack(ItemRegister.SteelPlates.get()), true);
                }
                break;
                case "item.law_assist_adventure.tin_ingot": {
                    player.drop(new ItemStack(ItemRegister.TinPlates.get()), true);
                }
                break;
            }
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
