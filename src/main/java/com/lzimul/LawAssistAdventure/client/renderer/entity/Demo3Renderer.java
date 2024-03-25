package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo3Model;
import com.lzimul.LawAssistAdventure.entity.Demo3Animal;
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

public class Demo3Renderer extends EntityRenderer<Demo3Animal> {
    private final EntityModel<Demo3Animal> DemoModel;

    public Demo3Renderer(EntityRendererProvider.Context context) {
        super(context);
        DemoModel = new Demo3Model<>(context.bakeLayer(Demo3Model.LAYER_LOCATION));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo3Animal demo) {
        return new ResourceLocation(MODID, "textures/entity/demo2.png");
    }

    @Override
    public void render(@NotNull Demo3Animal entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, multiBufferSource, packedLight);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(45));
        poseStack.translate(0, -1, 0);
        VertexConsumer buffer = multiBufferSource.getBuffer(this.DemoModel.renderType(this.getTextureLocation(entity)));
        this.DemoModel.renderToBuffer(poseStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        poseStack.popPose();
    }
}
