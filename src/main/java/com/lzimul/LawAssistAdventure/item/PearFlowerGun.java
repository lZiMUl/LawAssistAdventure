package com.lzimul.LawAssistAdventure.item;

import com.lzimul.LawAssistAdventure.client.helper.AmmunitionHelper;
import com.lzimul.LawAssistAdventure.client.helper.WeaponHelper;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.SoundRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PearFlowerGun extends SwordItem {
    private static final AmmunitionHelper ammunitionHelper = new AmmunitionHelper(1, 3, 0);

    public PearFlowerGun() {
        super(new WeaponHelper(1, 400, 1F, 5F, 1, () -> Ingredient.of(ItemRegister.PearFlowerGun.asItem())), 3, -2.4f, new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (!level.isClientSide() && player.isAlive()) {
            ammunitionHelper.setPlayer(player);
            player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition", ammunitionHelper.getCurrent(), ammunitionHelper.getLimit(), ammunitionHelper.getTotal()));
            if (player.isCrouching()) {
                if (ammunitionHelper.getCurrent() != ammunitionHelper.getLimit()) {
                    if (ammunitionHelper.getTotal() != 0) {
                        ammunitionHelper.reload();
                        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.Glock19Reload.get(), player.getSoundSource(), 1.0F, 1.0F);
                        player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.reloaded"));
                    } else {
                        player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.empty"));
                    }
                } else {
                    player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.full"));
                }
            } else if (ammunitionHelper.getCurrent() != 0) {
                ammunitionHelper.fire(1);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegister.Glock19Fire.get(), player.getSoundSource(), 1.0F, 1.0F);
            } else {
                player.sendSystemMessage(Component.translatable("event.law_assist_adventure.ammunition.low"));
            }
        }
        return super.use(level, player, interactionHand);
    }
}
