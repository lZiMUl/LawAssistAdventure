package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo1Model;
import com.lzimul.LawAssistAdventure.entity.Demo1Animal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Demo1Renderer extends MobRenderer<Demo1Animal, Demo1Model<Demo1Animal>> {
    public Demo1Renderer(EntityRendererProvider.Context context) {
        super(context, new Demo1Model<>(context.bakeLayer(Demo1Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo1Animal demo) {
        return new ResourceLocation(MODID, "textures/entity/demo1.png");
    }

}
