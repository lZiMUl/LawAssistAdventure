package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IndustrialSmeltingFurnacesBlock extends Block {
    public IndustrialSmeltingFurnacesBlock() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }

//    @Override
//    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
    // TODO 待开发点击工业冶炼炉显示界面
//        player.sendSystemMessage(Component.literal(IndustrialSmeltingFurnacesBlock.class.getName()));
//        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
//    }
}
