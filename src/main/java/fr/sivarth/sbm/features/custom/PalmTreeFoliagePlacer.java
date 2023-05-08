package fr.sivarth.sbm.features.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class PalmTreeFoliagePlacer extends FoliagePlacer {

    public PalmTreeFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FoliagePlacerType.BLOB_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int baseHeight, Foliage foliage, int radius, int height, Set<BlockPos> pos, int foliageHeight, MutableBoundingBox boundingBox) {
        BlockPos foliagePos = foliage.foliagePos();
        BlockStateProvider blockStateProvider = config.leavesProvider;
        int foliageRadius = foliage.radiusOffset();

        IWorldReader worldReader = (IWorldReader) world;

        for (int offsetY = 0; offsetY < foliageRadius; offsetY++) {
            int leavesLayer = foliageRadius - offsetY;
            int leavesLayerHeight = foliageRadius - offsetY / 2;

            for (int offsetX = -leavesLayer; offsetX <= leavesLayer; offsetX++) {
                for (int offsetZ = -leavesLayer; offsetZ <= leavesLayer; offsetZ++) {
                    if (Math.abs(offsetX) != leavesLayer || Math.abs(offsetZ) != leavesLayer || random.nextInt(2) != 0) {
                        BlockPos leafPos = foliagePos.offset(offsetX, offsetY, offsetZ);
                        if (canPlaceLeafAt(worldReader, leafPos)) {
                            world.setBlock(leafPos, blockStateProvider.getState(random, leafPos), 2);
                            boundingBox.expand(new MutableBoundingBox(leafPos, leafPos));
                        }
                    }
                }
            }

            if (leavesLayerHeight <= 1) {
                continue;
            }

            int offsetX = -leavesLayer;
            int offsetZ = -leavesLayer;

            while (offsetX <= leavesLayer) {
                for (int i = 0; i < 2; i++) {
                    offsetX += random.nextInt(leavesLayerHeight) - random.nextInt(leavesLayerHeight);
                    offsetZ += random.nextInt(leavesLayerHeight) - random.nextInt(leavesLayerHeight);

                    if (Math.abs(offsetX) < leavesLayer || Math.abs(offsetZ) < leavesLayer) {
                        BlockPos leafPos = foliagePos.offset(offsetX, offsetY, offsetZ);

                        if (canPlaceLeafAt(worldReader, leafPos)) {
                            world.setBlock(leafPos, blockStateProvider.getState(random, leafPos), 2);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int foliageHeight(Random random, int heigth, BaseTreeFeatureConfig config) {
        return 4;
    }

    @Override
    protected boolean shouldSkipLocation(Random random, int baseHeight, int x, int z, int radius, boolean skipIfAir) {
        return false;
    }

    private boolean canPlaceLeafAt(IWorldReader world, BlockPos pos) {
        BlockState currentState = world.getBlockState(pos);
        Block currentBlock = currentState.getBlock();

        return currentBlock.canBeReplacedByLeaves(currentState, world, pos);
    }

}
