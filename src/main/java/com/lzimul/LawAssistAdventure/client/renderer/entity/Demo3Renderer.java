package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo3Model;
import com.lzimul.LawAssistAdventure.entity.Demo3Animal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Demo3Renderer extends MobRenderer<Demo3Animal, Demo3Model<Demo3Animal>> {

    public Demo3Renderer(EntityRendererProvider.Context context) {
        super(context, new Demo3Model<>(context.bakeLayer(Demo3Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo3Animal demo) {
        return new ResourceLocation(MODID, "textures/entity/demo2.png");
    }
}
