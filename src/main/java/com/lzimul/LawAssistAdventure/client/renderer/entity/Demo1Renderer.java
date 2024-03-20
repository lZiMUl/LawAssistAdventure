package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo1Model;
import com.lzimul.LawAssistAdventure.entity.Demo1;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Demo1Renderer extends EntityRenderer<Demo1> {
    private final EntityModel<Demo1> DemoModel;

    public Demo1Renderer(EntityRendererProvider.Context context) {
        super(context);
        DemoModel = new Demo1Model<>(context.bakeLayer(Demo1Model.LAYER_LOCATION));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo1 demo) {
        return new ResourceLocation(MODID, "textures/entity/demo1.png");
    }

    @Override
    public void render(@NotNull Demo1 entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, multiBufferSource, packedLight);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(45));
        poseStack.translate(0, -1, 0);
        VertexConsumer buffer = multiBufferSource.getBuffer(this.DemoModel.renderType(this.getTextureLocation(entity)));
        this.DemoModel.renderToBuffer(poseStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        poseStack.popPose();
    }
}
