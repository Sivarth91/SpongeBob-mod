package fr.sivarth.sbm.world;

import fr.sivarth.sbm.SBM;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SBM.MODID)
public class ModWorldEvents {

    /**
     *
     * @param e
     */
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent e) {
        
    }


}
