package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PlanktonModel<T extends Entity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer legs;
    private final ModelRenderer arms;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;

    public PlanktonModel() {
        texWidth = 32;
        texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 23.0F, 0.0F);
        body.texOffs(0, 0).addBox(-4.0F, -15.0F, -2.0F, 7.0F, 12.0F, 3.0F, 0.0F, false);
        body.texOffs(0, 20).addBox(-3.0F, -18.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.texOffs(19, 18).addBox(1.0F, -18.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.texOffs(15, 19).addBox(2.0F, -20.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.texOffs(16, 15).addBox(-4.0F, -20.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 1.0F, 0.0F);
        body.addChild(legs);
        legs.texOffs(12, 15).addBox(-3.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        legs.texOffs(8, 15).addBox(1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        arms = new ModelRenderer(this);
        arms.setPos(0.0F, 1.0F, 0.0F);
        body.addChild(arms);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.1134F);
        cube_r1.texOffs(0, 15).addBox(-6.0F, -9.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        arms.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.1134F);
        cube_r2.texOffs(4, 15).addBox(4.0F, -9.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
