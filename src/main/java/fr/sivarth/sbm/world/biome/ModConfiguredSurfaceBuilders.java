package fr.sivarth.sbm.world.biome;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> BIKINI_BOTTOM_SURFACE = registerSurfaceBuilder("bikini_bottom_surface", SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
        Blocks.SAND.defaultBlockState(), // top block (like grass)
        Blocks.SANDSTONE.defaultBlockState(), // under block (like dirt)
        ModBlocks.ALUMINIUM_WALL_BLOCK.get().defaultBlockState() // third block (like stone)
    )));



    /**
     *
     * @param name
     * @param csb
     * @return configured surface builder for your biome
     * @param <SC>
     */
    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> registerSurfaceBuilder(String name, ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(SBM.MODID ,name), csb);
    }


}
