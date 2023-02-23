package fr.sivarth.sbm.world.biome.custom;

import fr.sivarth.sbm.entity.ModEntityTypes;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class BikiniBottomBiome {

    public static Biome makeBikiniBottomBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobSpawnInfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobSpawnInfo$builder);
        DefaultBiomeFeatures.ambientSpawns(mobSpawnInfo$builder);
        mobSpawnInfo$builder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.SPONGE_BOB.get(), 7, 1, 3));
        mobSpawnInfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.GARY.get(), 3, 1, 3));
        mobSpawnInfo$builder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.PLANKTON.get(), 1, 1, 2));
        mobSpawnInfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.PATRICK.get(), 4, 1, 3));

        BiomeGenerationSettings.Builder biomeGenerationSettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);
        biomeGenerationSettings$builder.addStructureStart(StructureFeatures.MINESHAFT);
        biomeGenerationSettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);

        return (new Biome.Builder())
            .precipitation(Biome.RainType.NONE)
            .biomeCategory(Biome.Category.OCEAN)
            .depth(depth)
            .scale(scale)
            .temperature(1.5f)
            .downfall(0.9f)
            .specialEffects((new BiomeAmbience.Builder())
                .waterColor(0x0000ff)
                .waterFogColor(0x159FF7)
                .fogColor(0x159FF7)
                .skyColor(0x159FF7)
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.UNDERWATER, 0.003f))
                .skyColor(0x159FF7)
                .ambientMoodSound(new MoodSoundAmbience(SoundEvents.WATER_AMBIENT, 6000, 8, 2.0D))
                .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_UNDERWATER_LOOP, 0.0111D))
                .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_UNDER_WATER))
                .build())
            .mobSpawnSettings(mobSpawnInfo$builder.build())
            .generationSettings(biomeGenerationSettings$builder.build())
            .build();
    }
}
