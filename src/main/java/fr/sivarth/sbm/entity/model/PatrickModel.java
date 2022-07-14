package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PatrickModel<T extends Entity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer arms;
    private final ModelRenderer rightArm;
    private final ModelRenderer leftArm;
    private final ModelRenderer legs;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;

    public PatrickModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 24.0F, 0.0F);
        head.texOffs(0, 16).addBox(-3.0F, -29.0F, -7.0F, 7.0F, 14.0F, 5.0F, 0.0F, false);
        head.texOffs(29, 0).addBox(-1.0F, -32.0F, -6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(-5.0F, -15.0F, -8.0F, 11.0F, 9.0F, 7.0F, 0.0F, false);

        arms = new ModelRenderer(this);
        arms.setPos(0.0F, 24.0F, 0.0F);


        rightArm = new ModelRenderer(this);
        rightArm.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(rightArm);
        rightArm.texOffs(33, 34).addBox(-8.0F, -15.0F, -6.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(leftArm);
        leftArm.texOffs(24, 25).addBox(6.0F, -15.0F, -6.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);
        legs.texOffs(24, 16).addBox(-5.0F, -6.0F, -7.0F, 11.0F, 4.0F, 5.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(rightLeg);
        rightLeg.texOffs(12, 35).addBox(2.0F, -2.0F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(leftLeg);
        leftLeg.texOffs(0, 35).addBox(-4.0F, -2.0F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        arms.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }


}
