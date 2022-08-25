package fr.sivarth.sbm.world.gen;

import fr.sivarth.sbm.world.biome.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {

    public static void generateBiomes() {
        addBiome(ModBiomes.BIKINI_BOTTOM_BIOME.get(), BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
    }

    /**
     *
     * @param biome
     * @param type
     * @param weight
     * @param types
     */
    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }



}
