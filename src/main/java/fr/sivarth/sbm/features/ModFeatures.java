package fr.sivarth.sbm.features;

import fr.sivarth.sbm.block.ModBlocks;
import fr.sivarth.sbm.features.custom.PalmTreeFoliagePlacer;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFeatures {

    public static final ConfiguredFeature<?, ?> ALUMINIUM_ORE_FEATURE = registerFeature("ore_aluminium", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ALUMINIUM_BLOCK.get().getBlock().defaultBlockState(), 10)));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PALM_TREE_FEATURE = registerFeature("palm_tree_feature", Feature.TREE.configured(
        new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.PALM_LOG.get().defaultBlockState()),
            new SimpleBlockStateProvider(ModBlocks.PALM_LEAVES.get().defaultBlockState()),
            new PalmTreeFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0)),
            new ForkyTrunkPlacer(4, 1, 3),
            new TwoLayerFeature(1, 1, 1)
        ).ignoreVines().build()
    ));

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (event.getCategory() != Biome.Category.NETHER) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ALUMINIUM_ORE_FEATURE);
        }

        /*if (event.getCategory() == Biome.Category.BEACH) {
            generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PALM_TREE_FEATURE);
        }*/
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> registerFeature(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }

}