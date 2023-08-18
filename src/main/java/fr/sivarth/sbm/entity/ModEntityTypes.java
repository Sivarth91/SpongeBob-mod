package fr.sivarth.sbm.entity;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.entity.custom.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SBM.MODID);

    /**
     *
     * @param bus
     */
    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }


    public static final RegistryObject<EntityType<SpongeBobEntity>> SPONGE_BOB = ENTITY_TYPES.register("sponge_bob",
            () -> EntityType.Builder.of(SpongeBobEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f, 1.7f)
                    .build(new ResourceLocation(SBM.MODID, "sponge_bob").toString()));

    public static final RegistryObject<EntityType<PatrickEntity>> PATRICK = ENTITY_TYPES.register("patrick",
        () -> EntityType.Builder.of(PatrickEntity::new, EntityClassification.CREATURE)
            .sized(0.5f, 1.8f)
            .build(new ResourceLocation(SBM.MODID, "patrick").toString()));

    public static final RegistryObject<EntityType<GaryEntity>> GARY = ENTITY_TYPES.register("gary",
        () -> EntityType.Builder.of(GaryEntity::new, EntityClassification.CREATURE)
            .sized(0.5f, 0.8f)
            .build(new ResourceLocation(SBM.MODID, "gary").toString()));

    public static final RegistryObject<EntityType<PlanktonEntity>> PLANKTON = ENTITY_TYPES.register("plankton",
        () -> EntityType.Builder.of(PlanktonEntity::new, EntityClassification.MONSTER)
            .sized(0.5f, 1.2f)
            .build(new ResourceLocation(SBM.MODID, "plankton").toString()));

    public static final RegistryObject<EntityType<ModBoatEntity>> CORAL_WOOD_BOAT = ENTITY_TYPES.register("coral_wood_boat",
        () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, EntityClassification.MISC)
            .sized(0.5f, 0.5f)
            .build(new ResourceLocation(SBM.MODID, "coral_wood_boat").toString()));
}
