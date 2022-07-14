package fr.sivarth.sbm.entity.render;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.custom.SpongeBobEntity;
import fr.sivarth.sbm.entity.model.SpongeBobModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpongeBobRender extends MobRenderer<SpongeBobEntity, SpongeBobModel<SpongeBobEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SBM.MODID, "textures/entity/sponge_bob.png");

    /**
     *
     * @param rendererManagerIn
     */
    public SpongeBobRender(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new SpongeBobModel<>(), 0.7f);
    }

    /**
     *
     * @param entity
     * @return texture
     */
    @Override
    public ResourceLocation getTextureLocation(SpongeBobEntity entity) {
        return TEXTURE;
    }

}
