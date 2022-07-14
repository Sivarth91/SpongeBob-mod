package fr.sivarth.sbm.utils;

import fr.sivarth.sbm.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFeatures {

    /**
     *
     * @param name
     * @param feature
     * @return feature registering
     * @param <FC>
     */
    public static final <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> registerFeature(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }

    public ConfiguredFeature<?, ?> ALUMINIUM_ORE_FEATURE;


    public void init() {
        ALUMINIUM_ORE_FEATURE = registerFeature("ore_aluminium", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ALUMINIUM_BLOCK.get().getBlock().defaultBlockState(), 10)));
    }

    /**
     *
     * @param event
     */
    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (event.getCategory() != Biome.Category.NETHER) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ALUMINIUM_ORE_FEATURE);
        }
    }
}