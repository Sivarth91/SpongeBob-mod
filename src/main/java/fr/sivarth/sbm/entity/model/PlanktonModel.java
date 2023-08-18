package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PlanktonModel<T extends Entity> extends EntityModel<T> {

	private final ModelRenderer body;
	private final ModelRenderer horns;
	private final ModelRenderer horn1;
	private final ModelRenderer horn2;
	private final ModelRenderer legs;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer arms;
	private final ModelRenderer arm1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer arm2;
	private final ModelRenderer cube_r2;

	public PlanktonModel() {
		texWidth = 32;
		texHeight = 32;

		body = new ModelRenderer(this);

		body.setPos(0.0F, 24.0F, 0.0F);
		body.texOffs(0, 0).addBox(-3.0F, -16.0F, -2.0F, 7.0F, 12.0F, 3.0F, 0.0F, false);

		horns = new ModelRenderer(this);
		horns.setPos(0.0F, 0.0F, 0.0F);
		body.addChild(horns);
		

		horn1 = new ModelRenderer(this);
		horn1.setPos(0.0F, 0.0F, 0.0F);
		horns.addChild(horn1);
		horn1.texOffs(0, 20).addBox(-2.0F, -19.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		horn1.texOffs(19, 18).addBox(-3.0F, -21.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		horn2 = new ModelRenderer(this);
		horn2.setPos(0.0F, 0.0F, 0.0F);
		horns.addChild(horn2);
		horn2.texOffs(15, 19).addBox(2.0F, -19.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		horn2.texOffs(16, 15).addBox(3.0F, -21.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setPos(0.0F, 24.0F, 0.0F);
		

		leg1 = new ModelRenderer(this);
		leg1.setPos(0.0F, 0.0F, 0.0F);
		legs.addChild(leg1);
		leg1.texOffs(12, 15).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setPos(0.0F, 0.0F, 0.0F);
		legs.addChild(leg2);
		leg2.texOffs(8, 15).addBox(2.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setPos(0.0F, 24.0F, 0.0F);
		

		arm1 = new ModelRenderer(this);
		arm1.setPos(0.0F, 0.0F, 0.0F);
		arms.addChild(arm1);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		arm1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2182F);
		cube_r1.texOffs(4, 15).addBox(-6.0F, -10.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		arm2 = new ModelRenderer(this);
		arm2.setPos(0.0F, 0.0F, 0.0F);
		arms.addChild(arm2);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		arm2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2182F);
		cube_r2.texOffs(0, 15).addBox(6.0F, -10.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
        float animationLength = 3.0F;
        float normalizedTime = (ageInTicks % (animationLength * 20)) / (animationLength * 20);

        // Legs rotation
        float legsRotation = interpolateRotation(normalizedTime, 0.0F, 0.0F, 0.01F, 0.01F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        setRotationAngle(legs, 0.0F, 0.0F, legsRotation);

        // Leg1 rotation
        float leg1Rotation = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, -5.0F, 0.0F, 5.0F);
        setRotationAngle(leg1, 0.0F, 0.0F, leg1Rotation);

        // Leg2 rotation
        float leg2Rotation = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, 5.0F, 0.0F, -5.0F);
        setRotationAngle(leg2, 0.0F, 0.0F, leg2Rotation);

        // Arm1 rotation and position
        float arm1Rotation = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 2.5417F, 3.0F, 0.0F, -15.0F, 7.5F, 0.0F);
        float arm1Position = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 2.5417F, 3.0F, 0.0F, -3.0F, 0.0F, 0.0F);
        setRotationAngle(arm1, 0.0F, 0.0F, arm1Rotation);
        arm1.z += arm1Position;

        // Arm2 rotation and position
        float arm2Rotation = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 2.5417F, 3.0F, 0.0F, 7.5F, -15.0F, 0.0F);
        float arm2Position = interpolateRotation(normalizedTime, 0.0F, 1.0F, 2.0F, 2.5417F, 3.0F, 0.0F, 1.0F, 0.0F, 0.0F);
        setRotationAngle(arm2, 0.0F, 0.0F, arm2Rotation);
        arm2.z += arm2Position;

        // Eye rotation
        /*float eyeRotation = interpolateRotation(normalizedTime, 0.0F, 0.0F, 0.01F, 0.01F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        setRotationAngle(eye, 0.0F, 0.0F, eyeRotation);*/
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		arms.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

    private float interpolateRotation(float time, float keyframe1Time, float keyframe2Time, float keyframe3Time, float keyframe4Time, float keyframe5Time, float keyframe1Value, float keyframe2Value, float keyframe3Value, float keyframe4Value) {
        if (time < keyframe1Time) {
            return keyframe1Value;
        } else if (time < keyframe2Time) {
            return keyframe1Value + (keyframe2Value - keyframe1Value) * (time - keyframe1Time) / (keyframe2Time - keyframe1Time);
        } else if (time < keyframe3Time) {
            return keyframe2Value;
        } else if (time < keyframe4Time) {
            return keyframe2Value + (keyframe3Value - keyframe2Value) * (time - keyframe3Time) / (keyframe4Time - keyframe3Time);
        } else if (time < keyframe5Time) {
            return keyframe3Value;
        } else {
            return keyframe3Value + (keyframe4Value - keyframe3Value) * (time - keyframe5Time) / (1.0F - keyframe5Time);
        }
    }
}