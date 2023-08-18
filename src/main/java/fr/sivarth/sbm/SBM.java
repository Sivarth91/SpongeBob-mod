package fr.sivarth.sbm;

import fr.sivarth.sbm.block.ModBlocks;
import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.entity.custom.*;
import fr.sivarth.sbm.item.ModItems;
import fr.sivarth.sbm.world.biome.ModBiomes;
import fr.sivarth.sbm.world.gen.ModBiomeGeneration;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
        ModBiomes.registerBiomes(bus);
    }

    /**
     *
     * @param event
     */
    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.SPONGE_BOB.get(), SpongeBobEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PATRICK.get(), PatrickEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.GARY.get(), GaryEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PLANKTON.get(), PlanktonEntity.setCustomAttributes().build());
        });
    }

    /**
     *
     * @param event
     */
    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.ONIONS.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.TOMATOES.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ROUND_WINDOW.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ALUMINIUM_DOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ALUMINIUM_TRAPDOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REINFORCED_ALUMINIUM_DOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REINFORCE_ALUMINIUM_TRAPDOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PALM_SAPLING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PALM_LEAVES.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.CORAL_PLANKS_FENCE.get(), RenderType.cutout());

            ModBiomeGeneration.generateBiomes();
        });
    }


}
