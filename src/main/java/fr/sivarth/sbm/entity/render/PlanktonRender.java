package fr.sivarth.sbm.entity.render;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.custom.PlanktonEntity;
import fr.sivarth.sbm.entity.model.PlanktonModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PlanktonRender extends MobRenderer<PlanktonEntity, PlanktonModel<PlanktonEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SBM.MODID, "textures/entity/plankton.png");

    /**
     *
     * @param rendererManagerIn
     */
    public PlanktonRender(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new PlanktonModel<>(), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(PlanktonEntity entity) {
        return TEXTURE;
    }
}
