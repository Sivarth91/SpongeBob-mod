package fr.sivarth.sbm.entity.custom;

import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class SquidwardEntity extends AnimalEntity {

    private static final Ingredient TEMPTATION_INGREDIENT = Ingredient.of(ModItems.SPATULA.get());
    private int squidwardTimer;

    public SquidwardEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.010D)
            .add(Attributes.ARMOR, 3D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
            .add(Attributes.MAX_HEALTH, 8.0D)
            .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 2D);
    }

    /**
     *
     * @param world
     * @param ageable
     * @return Squidward entity type
     */
    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        return ModEntityTypes.SQUIDWARD.get().create(world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, TEMPTATION_INGREDIENT, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 7.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return 1 + this.random.nextInt(4);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SQUID_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SQUID_SQUIRT,  0.15f, 1.0f);
    }

    @Override
    protected void tickLeash() {
        super.tickLeash();
    }

    @Override
    public void aiStep() {
        if (this.level.isClientSide) {
            this.squidwardTimer = Math.max(0, this.squidwardTimer - 1);
        }
        super.aiStep();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEnityEvent(byte id) {
        if (id == 10) {
            this.squidwardTimer = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

}
