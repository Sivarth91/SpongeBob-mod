package fr.sivarth.sbm.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AluminiumOre extends OreBlock {

    public AluminiumOre() {
        super(Block.Properties.of(Material.METAL)
            .strength(3.2f, 4.0f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(1)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops());
    }


}
