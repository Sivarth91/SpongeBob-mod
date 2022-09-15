package fr.sivarth.sbm.entity.render;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.custom.PatrickEntity;
import fr.sivarth.sbm.entity.model.PatrickModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PatrickRender extends MobRenderer<PatrickEntity, PatrickModel<PatrickEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SBM.MODID, "textures/entity/patrick.png");

    /**
     *
     * @param rendererManagerIn
     */
    public PatrickRender(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new PatrickModel<>(), 0.4f);
    }

    /**
     *
     * @param entity
     * @return texture
     */
    @Override
    public ResourceLocation getTextureLocation(PatrickEntity entity) {
        return TEXTURE;
    }

}
