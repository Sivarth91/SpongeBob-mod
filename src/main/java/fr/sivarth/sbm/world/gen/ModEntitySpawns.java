package fr.sivarth.sbm.world.gen;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;

public class ModEntitySpawns {

    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToAllBiomes(event.getSpawns(), ModEntityTypes.SPONGE_BOB.get(), 40, 2, 4);
        addEntityToSpecificBiomes(event, ModEntityTypes.PLANKTON.get(), 50, 4, 10, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST);
        addEntityToAllBiomesExceptThese(event, ModEntityTypes.GARY.get(), 30, 2, 5, Biomes.BADLANDS, Biomes.BAMBOO_JUNGLE);
    }


    private static void addEntityToAllBiomes(MobSpawnInfoBuilder spawns, EntityType<?> type, int weight, int minCount, int maxCount) {
        List<MobSpawnInfo.Spawners> base = spawns.getSpawner(type.getCategory());
        base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
    }


    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::location).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if (!isBiomeSelected) {
            addEntityToAllBiomes(event.getSpawns(), type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::location).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if (isBiomeSelected) {
            addEntityToAllBiomes(event.getSpawns(), type, weight, minCount, maxCount);
        }
    }

}
