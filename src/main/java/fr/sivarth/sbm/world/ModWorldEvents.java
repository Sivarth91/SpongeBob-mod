package fr.sivarth.sbm.world;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.world.gen.ModEntitySpawns;
import fr.sivarth.sbm.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SBM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldEvents {

    /**
     *
     * @param event
     */
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModEntitySpawns.onEntitySpawn(event);
    }




}
