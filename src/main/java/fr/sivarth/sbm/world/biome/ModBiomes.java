package fr.sivarth.sbm.world.biome;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.ModEntityTypes;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
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

    /**
     *
     * @param surfaceBuilder
     * @param depth
     * @param scale
     * @return biome builder
     */
    private static Biome makeBikiniBottomBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobSpawnInfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobSpawnInfo$builder);
        DefaultBiomeFeatures.ambientSpawns(mobSpawnInfo$builder);
        mobSpawnInfo$builder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.SPONGE_BOB.get(), 50, 1, 3));
        BiomeGenerationSettings.Builder biomeGenerationSettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);

        biomeGenerationSettings$builder.addStructureStart(StructureFeatures.MINESHAFT);

        return (new Biome.Builder())
            .precipitation(Biome.RainType.NONE)
            .biomeCategory(Biome.Category.OCEAN)
            .depth(depth)
            .scale(scale)
            .temperature(1.5f)
            .downfall(0.9f)
            .specialEffects((new BiomeAmbience.Builder())
                .waterColor(3)
                .waterFogColor(3)
                .fogColor(3)
                .skyColor(getSkyColorWithTemperature(0.1f))
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.UNDERWATER, 0.003f))
                .skyColor(3)
                .ambientMoodSound(new MoodSoundAmbience(SoundEvents.WATER_AMBIENT, 6000, 8, 2.0D))
                .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_UNDERWATER_LOOP, 0.0111D))
                .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_UNDER_WATER))
                .build())
            .mobSpawnSettings(mobSpawnInfo$builder.build()).generationSettings(biomeGenerationSettings$builder.build())
            .build();
    }

    /**
     *
     * @param temperature
     * @return temperature
     */
    private static int getSkyColorWithTemperature(float temperature) {
        float lvt_1_1_ = temperature / 3.0f;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0f, 1.0f);
        return MathHelper.hsvToRgb(0.2460909F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static final RegistryObject<Biome> BIKINI_BOTTOM_BIOME = BIOMES.register("bikini_bottom_biome", () -> makeBikiniBottomBiome(() -> ModConfiguredSurfaceBuilders.BIKINI_BOTTOM_SURFACE, 0.125f, 0.05f));



}
