package com.lzimul.LawAssistAdventure.client.renderer.entity;

import com.lzimul.LawAssistAdventure.client.model.entity.Demo2Model;
import com.lzimul.LawAssistAdventure.entity.Demo2;
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

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public class Demo2Renderer extends EntityRenderer<Demo2> {
    private final EntityModel<Demo2> DemoModel;

    public Demo2Renderer(EntityRendererProvider.Context context) {
        super(context);
        DemoModel = new Demo2Model<>(context.bakeLayer(Demo2Model.LAYER_LOCATION));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Demo2 demo) {
        return new ResourceLocation(MODID, "textures/entity/demo2.png");
    }

    @Override
    public void render(@NotNull Demo2 entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, multiBufferSource, packedLight);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(45));
        poseStack.translate(0, -1, 0);
        VertexConsumer buffer = multiBufferSource.getBuffer(this.DemoModel.renderType(this.getTextureLocation(entity)));
        this.DemoModel.renderToBuffer(poseStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        poseStack.popPose();
    }
}
