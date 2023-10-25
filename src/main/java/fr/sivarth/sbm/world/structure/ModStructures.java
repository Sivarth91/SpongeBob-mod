package fr.sivarth.sbm.world.structure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.world.structure.structures.CoralHouse1Structure;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ModStructures {

    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, SBM.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> CORAL_HOUSE1 = STRUCTURES.register("coral_house1", CoralHouse1Structure::new);

    public static void setupStructures() {
        setupMapSpacingAndLand(CORAL_HOUSE1.get(), new StructureSeparationSettings(100, 50, 1234567890), true);
    }

    /**
     *
     * @param structure
     * @param structureSeparationSettings
     * @param transformSurroundingLand
     * @param <F>
     */
    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder()
                .addAll(Structure.NOISE_AFFECTING_FEATURES)
                .add(structure)
                .build();
        }

        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
            .putAll(DimensionStructuresSettings.DEFAULTS)
            .put(structure, structureSeparationSettings)
            .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.stream().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.structureSettings().structureConfig();

            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.structureSettings().structureConfig();
            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }

    /**
     *
     * @param eventBus
     */
    public static void registerStructures(IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }

    /**
     * #public-f net.minecraft.world.gen.FlatGenerationSettings field_202247_j #STRUCTURES
     */
}
