package com.lzimul.LawAssistAdventure.block.entity;

import com.lzimul.LawAssistAdventure.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class CraftingTableEntity extends BlockEntity {
    protected final ContainerData data;
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private int progress = 0;
    private int progressMax = 100;



    public CraftingTableEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegister.CraftingTableEntity.get(), blockPos, blockState);
        this.data = new ContainerData() {

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> progress;
                    case 1 -> progressMax;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> progress = value;
                    case 1 -> progressMax = value;
                }
                ;
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }
}
