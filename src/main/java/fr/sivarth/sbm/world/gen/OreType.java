package fr.sivarth.sbm.world.gen;

import fr.sivarth.sbm.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    ALUMINIUM(Lazy.of(ModBlocks.ALUMINIUM_ORE), 8, 25, 50);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    /**
     *
     * @returnv block
     */
    public Lazy<Block> getBlock() {
        return block;
    }

    /**
     *
     * @return maxVeinSize
     */
    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    /**
     *
     * @return minHeight
     */
    public int getMinHeight() {
        return minHeight;
    }

    /**
     *
     * @return maxHeight
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     *
     * @param block
     * @return ore
     * @return null
     */
    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }

}
