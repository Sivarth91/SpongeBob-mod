package fr.sivarth.sbm.world.gen;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = SBM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void spawnEntity(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getBiomeCategory() == Biome.Category.NETHER) {
             //nether entities spawn
            } else if (biome.getBiomeCategory() == Biome.Category.THEEND) {
                // end entities spawn
            } else {
                if (biome.getBiomeCategory() != Biome.Category.OCEAN) {
                    biome.getMobSettings().getMobs(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.SPONGE_BOB.get(), 10, 3, 5));
                    biome.getMobSettings().getMobs(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.PATRICK.get(), 10, 3, 5));
                    biome.getMobSettings().getMobs(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.GARY.get(), 10, 3, 5));
                    biome.getMobSettings().getMobs(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ModEntityTypes.PLANKTON.get(), 10, 3, 5));
                }
            }
        }
    }




}
