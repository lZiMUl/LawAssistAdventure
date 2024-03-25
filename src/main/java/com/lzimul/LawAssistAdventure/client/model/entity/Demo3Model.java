package com.lzimul.LawAssistAdventure.client.model.entity;

import com.lzimul.LawAssistAdventure.entity.Demo3Animal;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class Demo3Model<T extends Demo3Animal> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "demo2"), "main");
    private final ModelPart bone;
    private final ModelPart zhandou;

    public Demo3Model(ModelPart root) {
        this.bone = root.getChild("bone");
        this.zhandou = root.getChild("zhandou");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 41).addBox(-12.0F, -24.0F, 4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 57).addBox(-11.0F, -23.0F, 3.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F))
                .addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-9.0F, -20.0F, 14.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 33).addBox(2.0F, -20.0F, 2.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        partdefinition.addOrReplaceChild("zhandou", CubeListBuilder.create().texOffs(0, 26).addBox(-9.0F, -21.0F, -2.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(13, 58).addBox(-9.5F, -21.5F, -4.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));


        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        zhandou.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
