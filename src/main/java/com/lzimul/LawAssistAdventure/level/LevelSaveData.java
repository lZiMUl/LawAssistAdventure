package com.lzimul.LawAssistAdventure.level;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class LevelSaveData extends SavedData {
    private final Stack<ItemStack> stack = new Stack<>();

    private static LevelSaveData create() {
        return new LevelSaveData();
    }

    private static LevelSaveData decode(CompoundTag compoundTag) {
        LevelSaveData modLevelSaveData = LevelSaveData.create();
        modLevelSaveData.load(compoundTag);
        return modLevelSaveData;
    }

    public static LevelSaveData get(Level worldIn) {
        if (!(worldIn instanceof ServerLevel)) {
            throw new RuntimeException("Attempted to get the data from a client world. This is wrong.");
        }
        ServerLevel world = worldIn.getServer().getLevel(ServerLevel.OVERWORLD);
        assert world != null;
        DimensionDataStorage dataStorage = world.getDataStorage();
        return dataStorage.computeIfAbsent(new Factory<>(LevelSaveData::create, LevelSaveData::decode), MODID);
    }

    public void putItem(ItemStack itemStack) {
        stack.push(itemStack);
        setDirty();
    }

    public ItemStack getItem() {
        if (stack.isEmpty()) {
            return new ItemStack(Items.AIR);
        }
        setDirty();
        return stack.pop();
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag compoundTag) {
        ListTag listTag = new ListTag();
        stack.forEach((stack) -> {
            assert stack.getTag() != null;
            listTag.add(new CompoundTag().put("itemstack", stack.getTag()));
        });
        compoundTag.put("list", listTag);
        return compoundTag;
    }

    private void load(CompoundTag compoundTag) {
        LevelSaveData data = create();
        ListTag listTag = (ListTag) compoundTag.get("list");
        if (listTag != null) {
            for (Tag value : listTag) {
                CompoundTag tag = (CompoundTag) value;
                ItemStack itemStack = ItemStack.of(tag.getCompound("itemstack"));
                stack.push(itemStack);
            }
        }
    }
}
