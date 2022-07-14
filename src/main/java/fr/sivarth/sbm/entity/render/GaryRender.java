package fr.sivarth.sbm.entity.render;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.custom.GaryEntity;
import fr.sivarth.sbm.entity.model.GaryModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaryRender extends MobRenderer<GaryEntity, GaryModel<GaryEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SBM.MODID, "textures/entity/gary.png");

    /**
     *
     * @param rendererManagerIn
     */
    public GaryRender(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new GaryModel<>(), 0.1f);
    }

    /**
     *
     * @param entity
     * @return texture
     */
    @Override
    public ResourceLocation getTextureLocation(GaryEntity entity) {
        return TEXTURE;
    }

}
