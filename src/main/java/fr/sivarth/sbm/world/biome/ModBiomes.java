package fr.sivarth.sbm.world.biome;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.world.biome.custom.BikiniBottomBiome;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, SBM.MODID);

    /**
     *
     * @param bus
     */
    public static void registerBiomes(IEventBus bus) {
        BIOMES.register(bus);
    }


    public static final RegistryObject<Biome> BIKINI_BOTTOM_BIOME = BIOMES.register("bikini_bottom_biome", () -> BikiniBottomBiome.makeBikiniBottomBiome(() -> ModConfiguredSurfaceBuilders.BIKINI_BOTTOM_SURFACE, 0.125f, 0.05f));



}
