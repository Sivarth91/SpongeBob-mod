package fr.sivarth.sbm;

import fr.sivarth.sbm.block.ModBlocks;
import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.entity.custom.GaryEntity;
import fr.sivarth.sbm.entity.custom.PatrickEntity;
import fr.sivarth.sbm.entity.custom.PlanktonEntity;
import fr.sivarth.sbm.entity.custom.SpongeBobEntity;
import fr.sivarth.sbm.utils.ModFeatures;
import fr.sivarth.sbm.item.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SBM.MODID)
public class SBM {

    public static final String MODID = "sbm";

    public SBM() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent e) {
        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.SPONGE_BOB.get(), SpongeBobEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PATRICK.get(), PatrickEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.GARY.get(), GaryEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PLANKTON.get(), PlanktonEntity.setCustomAttributes().build());
        });

    }

    private void clientSetup(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {

        });
    }


}
