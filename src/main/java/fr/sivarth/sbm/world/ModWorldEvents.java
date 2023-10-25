package fr.sivarth.sbm.world;

import com.mojang.serialization.Codec;
import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.world.gen.ModEntitySpawns;
import fr.sivarth.sbm.world.gen.ModOreGeneration;
import fr.sivarth.sbm.world.gen.ModTreeGeneration;
import fr.sivarth.sbm.world.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = SBM.MODID)
public class ModWorldEvents {

    /**
     *
     * @param event
     */
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModEntitySpawns.onEntitySpawn(event);
    }

    /**
     *
     * @param event
     */
    @SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            try {
                Method GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "a");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey(
                    (Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator)
                );

                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) {
                    return;
                }

            } catch (Exception e) {
                LogManager.getLogger().error("Was unable to check if " + serverWorld.getDataStorage() + " is using Terraforged's Chunk Generator");
            }

            if (serverWorld.getChunkSource().generator instanceof FlatChunkGenerator && serverWorld.getDataStorage().equals(World.OVERWORLD)) {
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(ModStructures.CORAL_HOUSE1.get(), DimensionStructuresSettings.DEFAULTS.get(ModStructures.CORAL_HOUSE1.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig().structureConfig = tempMap;
        }
    }

}
