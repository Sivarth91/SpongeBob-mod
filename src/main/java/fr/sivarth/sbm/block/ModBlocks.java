package fr.sivarth.sbm.block;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.block.custom.AluminiumOre;
import fr.sivarth.sbm.block.custom.OnionBlock;
import fr.sivarth.sbm.item.ModItemGroup;
import fr.sivarth.sbm.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SBM.MODID);

    /**
     *
     * @param name
     * @param supplier
     * @return block
     */
    public static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
        return block;
    }

    public static final RegistryObject<Block> PINEAPPLE_BLOCK = registerBlock("pineapple_block", () -> new Block(AbstractBlock.Properties.of(Material.CORAL).strength(1.5f, 6).harvestTool(ToolType.SHOVEL).harvestLevel(0).sound(SoundType.SHROOMLIGHT)));
    public static final RegistryObject<Block> PINEAPPLE_LEAVES = registerBlock("pineapple_leaves", () -> new Block(AbstractBlock.Properties.of(Material.WOOD).strength(1, 2).sound(SoundType.LILY_PAD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUBE = registerBlock("tube", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3, 5).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SAND_ROAD = registerBlock("sand_road", () -> new Block(AbstractBlock.Properties.of(Material.SAND).strength(3.2f,2.1f).harvestTool(ToolType.SHOVEL).harvestLevel(0).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WINDOW = registerBlock("window", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(2.8f, 3.1f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ROUND_WINDOW = registerBlock("round_window", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(2.8f, 3.1f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.GLASS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINIUM_WALL_BLOCK = registerBlock("aluminium_wall_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(4.2f, 3.7f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINIUM_FLOOR = registerBlock("aluminium_floor", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(4.2f, 3.7f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANELLING = registerBlock("panelling", () -> new Block(AbstractBlock.Properties.of(Material.WOOD).strength(3.2f, 2.1f).harvestTool(ToolType.AXE).harvestLevel(0).sound(SoundType.WOOD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registerBlock("aluminium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(4.5f, 3.5f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINIUM_ORE = registerBlock("aluminium_ore", AluminiumOre::new);
    public static final RegistryObject<Block> ONIONS = BLOCKS.register("onion_crops", () -> new OnionBlock(AbstractBlock.Properties.copy(Blocks.WHEAT)));

}
