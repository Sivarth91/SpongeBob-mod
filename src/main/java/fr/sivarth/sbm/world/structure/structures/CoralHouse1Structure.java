package fr.sivarth.sbm.world.structure.structures;

import fr.sivarth.sbm.SBM;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class CoralHouse1Structure extends Structure<NoFeatureConfig> {

    public CoralHouse1Structure() {
        super(NoFeatureConfig.CODEC);
    }

    //@Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    /**
     *
     * @param chunkGenerator
     * @param biomeSource
     * @param seed
     * @param chunkRandom
     * @param chunkX
     * @param chunkZ
     * @param biome
     * @param chunkPos
     * @param featureConfig
     * @return
     */
    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        int x = (chunkX << 4) + 7;
        int z = (chunkZ << 4) + 7;
        BlockPos centerOfChunk = new BlockPos(x, 0, z);
        int landHeight = chunkGenerator.getBaseHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));

        return topBlock.getFluidState().isEmpty();
    }

    /**
     *
     * @return Coral House 1 structure
     */
    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return CoralHouse1Structure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {

        /**
         *
         * @param structureIn
         * @param chunkX
         * @param chunkZ
         * @param mutableBoundingBox
         * @param referenceIn
         * @param seedIn
         */
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        /**
         *
         * @param dynamicRegistryManager
         * @param chunkGenerator
         * @param templateManagerIn
         * @param chunkX
         * @param chunkZ
         * @param biomeIn
         * @param config
         */
        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            BlockPos blockPos = new BlockPos(x, 0, z);

            JigsawManager.addPieces(dynamicRegistryManager,
                new VillageConfig(() -> dynamicRegistryManager.registry(Registry.TEMPLATE_POOL_REGISTRY)
                    .get().get(new ResourceLocation(SBM.MODID, "coral_house1/start_pool")),
                    10), AbstractVillagePiece::new, chunkGenerator, templateManagerIn,
                blockPos, this.pieces, this.random, false, true
            );

            this.pieces.forEach(piece -> piece.move(0, 1, 0));
            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= 1);

            this.calculateBoundingBox();

            LogManager.getLogger().log(Level.DEBUG, "Coral House 1 at " +
                this.pieces.get(0).getBoundingBox().x0 + " " +
                this.pieces.get(0).getBoundingBox().y0 + " " +
                this.pieces.get(0).getBoundingBox().z0
            );

        }
    }

}
