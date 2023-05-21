package fr.sivarth.sbm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GaryModel<T extends Entity> extends EntityModel<T> {

	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer eye1;
	private final ModelRenderer eye2;

	public GaryModel() {
		texWidth = 64;
		texHeight = 64;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 24.0F, 0.0F);
		body.texOffs(0, 0).addBox(-3.0F, -2.0F, -8.0F, 7.0F, 2.0F, 16.0F, 0.0F, false);
		body.texOffs(0, 18).addBox(-3.0F, -12.0F, -4.0F, 7.0F, 10.0F, 12.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 24.0F, 0.0F);


		eye1 = new ModelRenderer(this);
		eye1.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(eye1);
		eye1.texOffs(12, 0).addBox(-2.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		eye1.texOffs(0, 6).addBox(-3.0F, -11.0F, -8.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye2 = new ModelRenderer(this);
		eye2.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(eye2);
		eye2.texOffs(0, 0).addBox(1.0F, -11.0F, -8.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		eye2.texOffs(12, 7).addBox(2.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        float animationLength = 5.0F;
        float animationSpeed = 3.3F;
        float normalizedTime = (ageInTicks % (animationLength * 20)) / (animationLength * 20);

        float eye1Rotation = interpolateRotation(normalizedTime, 0.0F, 0.5833F, 1.2083F, 1.625F, 2.0F, 0.0F, -5.0F, -7.5F, -5.0F, 0.0F);
        float eye2Rotation = interpolateRotation(normalizedTime, 0.0F, 0.5833F, 1.2083F, 1.625F, 2.0F, 0.0F, 5.0F, 5.0F, 2.5F, 0.0F);
        setRotationAngle(eye1, 0.0F, 0.0F, eye1Rotation);
        setRotationAngle(eye2, 0.0F, 0.0F, eye2Rotation);
    }

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

    private float interpolateRotation(float time, float keyframe1Time, float keyframe2Time, float keyframe3Time, float keyframe4Time, float keyframe5Time, float keyframe1Value, float keyframe2Value, float keyframe3Value, float keyframe4Value, float keyframe5Value) {
        float t;
        if (time <= keyframe1Time) {
            t = 0.0F;
        } else if (time >= keyframe5Time) {
            t = 1.0F;
        } else {
            t = (time - keyframe1Time) / (keyframe5Time - keyframe1Time);
        }

        float t2 = t * t;
        float t3 = t2 * t;

        float h1 = 2 * t3 - 3 * t2 + 1;
        float h2 = -2 * t3 + 3 * t2;
        float h3 = t3 - 2 * t2 + t;
        float h4 = t3 - t2;

        return h1 * keyframe1Value + h2 * keyframe5Value + h3 * (keyframe2Value - keyframe1Value) + h4 * (keyframe4Value - keyframe5Value);
    }
}