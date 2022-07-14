package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpongeBobModel<T extends Entity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer arms;
    private final ModelRenderer rightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer legs;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;

    public SpongeBobModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 24.0F, 0.0F);
        head.texOffs(0, 0).addBox(-6.0F, -27.0F, -4.0F, 12.0F, 15.0F, 5.0F, 0.0F, false);
        head.texOffs(34, 9).addBox(-1.0F, -19.0F, -7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 20).addBox(-6.0F, -12.0F, -4.0F, 12.0F, 5.0F, 5.0F, 0.0F, false);

        arms = new ModelRenderer(this);
        arms.setPos(0.0F, 24.0F, 0.0F);


        rightArm = new ModelRenderer(this);
        rightArm.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(rightArm);
        rightArm.texOffs(33, 27).addBox(6.0F, -15.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
        rightArm.texOffs(23, 35).addBox(7.0F, -13.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        rightArm.texOffs(12, 30).addBox(6.0F, -8.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        LeftArm = new ModelRenderer(this);
        LeftArm.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(LeftArm);
        LeftArm.texOffs(24, 30).addBox(-9.0F, -15.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
        LeftArm.texOffs(34, 14).addBox(-8.0F, -13.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        LeftArm.texOffs(0, 30).addBox(-9.0F, -8.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);


        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(rightLeg);
        rightLeg.texOffs(29, 20).addBox(2.0F, -1.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
        rightLeg.texOffs(0, 36).addBox(3.0F, -6.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        rightLeg.texOffs(34, 5).addBox(2.0F, -7.0F, -3.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(leftLeg);
        leftLeg.texOffs(33, 32).addBox(-5.0F, -7.0F, -3.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        leftLeg.texOffs(29, 0).addBox(-5.0F, -1.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
        leftLeg.texOffs(27, 35).addBox(-4.0F, -6.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        //this.head.xRot = headPitch * ((float) Math.PI / 180f);
        //this.head.yRot = netHeadYaw * ((float) Math.PI / 90f);
        //this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        //this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
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
