package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo2Model;
import com.lzimul.LawAssistAdventure.entity.Demo2Animal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Demo2Renderer extends MobRenderer<Demo2Animal, Demo2Model<Demo2Animal>> {

    public Demo2Renderer(EntityRendererProvider.Context context) {
        super(context, new Demo2Model<>(context.bakeLayer(Demo2Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo2Animal demo) {
        return new ResourceLocation(MODID, "textures/entity/demo2.png");
    }
}
