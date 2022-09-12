package fr.sivarth.sbm.entity.render;

import fr.sivarth.sbm.SBM;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

public class ModBoatRenderer extends BoatRenderer {

    private static final ResourceLocation BOAT_TEXTURE = new ResourceLocation(SBM.MODID, "textures/entity/boat/coral_wood_boat.png");

    public ModBoatRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(BoatEntity entity) {
        return BOAT_TEXTURE;
    }

}
