package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PlanktonModel<T extends Entity> extends EntityModel<T> {


    private final ModelRenderer body;
    private final ModelRenderer legs;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer amrs;
    private final ModelRenderer rightArm;
    private final ModelRenderer cube_r1;
    private final ModelRenderer leftArm;
    private final ModelRenderer cube_r2;

    public PlanktonModel() {
        texWidth = 32;
        texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(0.0F, -10.0F, -1.0F, 5.0F, 7.0F, 3.0F, 0.0F, false);
        body.texOffs(4, 10).addBox(1.0F, -14.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        body.texOffs(0, 10).addBox(3.0F, -14.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        body.texOffs(15, 15).addBox(2.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        body.texOffs(15, 13).addBox(0.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        body.texOffs(15, 9).addBox(4.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);


        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(rightLeg);
        rightLeg.texOffs(11, 14).addBox(3.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(leftLeg);
        leftLeg.texOffs(7, 14).addBox(1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        amrs = new ModelRenderer(this);
        amrs.setPos(0.0F, 24.0F, 0.0F);


        rightArm = new ModelRenderer(this);
        rightArm.setPos(0.0F, 0.0F, 0.0F);
        amrs.addChild(rightArm);
        rightArm.texOffs(0, 15).addBox(5.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(5.0F, 0.0F, 0.0F);
        rightArm.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -0.1309F);
        cube_r1.texOffs(12, 10).addBox(1.0F, -8.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(0.0F, 0.0F, 0.0F);
        amrs.addChild(leftArm);
        leftArm.texOffs(13, 0).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        leftArm.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.1309F);
        cube_r2.texOffs(8, 10).addBox(-2.0F, -8.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        amrs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
