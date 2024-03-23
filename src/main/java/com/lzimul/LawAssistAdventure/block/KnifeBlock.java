package com.lzimul.LawAssistAdventure.block;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class KnifeBlock extends Block {
    public KnifeBlock() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!level.isClientSide() && player.isAlive()) {
            if (player.getMainHandItem().isEmpty()) {
                player.setHealth(player.getHealth() - 1);
            }
            FoodData playerFoodData = player.getFoodData();
            if (playerFoodData.getFoodLevel() > 0) {
                playerFoodData.setFoodLevel(playerFoodData.getFoodLevel() - 1);
                switch (player.getMainHandItem().getItem().getDescriptionId()) {
                    case "item.minecraft.iron_ingot": {
                        player.drop(new ItemStack(ItemRegister.IronPlates.get().asItem()), true);
                        player.getMainHandItem().shrink(1);
                    }
                    break;
                    case "item.minecraft.gold_ingot": {
                        player.drop(new ItemStack(ItemRegister.GoldPlates.get().asItem()), true);
                        player.getMainHandItem().shrink(1);
                    }
                    break;
                    case "item.law_assist_adventure.copper_ingot": {
                        player.drop(new ItemStack(ItemRegister.CopperPlates.get().asItem()), true);
                        player.getMainHandItem().shrink(1);
                    }
                    break;
                    case "item.law_assist_adventure.steel_ingot": {
                        player.drop(new ItemStack(ItemRegister.SteelPlates.get().asItem()), true);
                        player.getMainHandItem().shrink(1);
                    }
                    break;
                    case "item.law_assist_adventure.tin_ingot": {
                        player.drop(new ItemStack(ItemRegister.TinPlates.get().asItem()), true);
                        player.getMainHandItem().shrink(1);
                    }
                }
            } else {
                player.sendSystemMessage(Component.literal("我好饿！"));
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return box(0, 0, 0, 16, 5, 16);
    }
}
