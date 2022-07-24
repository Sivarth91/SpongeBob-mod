package fr.sivarth.sbm.utils;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.entity.render.GaryRender;
import fr.sivarth.sbm.entity.render.PatrickRender;
import fr.sivarth.sbm.entity.render.PlanktonRender;
import fr.sivarth.sbm.entity.render.SpongeBobRender;
import fr.sivarth.sbm.item.custom.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SBM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    /**
     *
     * @param e
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPONGE_BOB.get(), SpongeBobRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PATRICK.get(), PatrickRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GARY.get(), GaryRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PLANKTON.get(), PlanktonRender::new);
    }

    /**
     *
     * @param event
     */
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

}
