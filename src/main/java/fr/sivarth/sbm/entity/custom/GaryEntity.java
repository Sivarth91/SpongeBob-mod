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

public class GaryEntity extends AnimalEntity {

    private static final Ingredient TEMPTATION_INGREDIENT = Ingredient.of(ModItems.SPATULA.get());
    private EatGrassGoal eatGrassGoal;
    private int patrickTimer;

    /**
     *
     * @param type
     * @param world
     */
    public GaryEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    /**
     *
     * @return mob attributes
     */
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.01D)
            .add(Attributes.ARMOR, 4D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
            .add(Attributes.MAX_HEALTH, 5.0D)
            .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 1D);
    }

    /**
     *
     * @param world
     * @param ageable
     * @return Gary entity type
     */
    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        return ModEntityTypes.PATRICK.get().create(world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, TEMPTATION_INGREDIENT, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 7.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    /**
     *
     * @param player
     * @return experience
     */
    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return 1 + this.random.nextInt(3);
    }

    /**
     *
     * @return ambient sound
     */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_AMBIENT;
    }

    /**
     *
     * @return death sound
     */
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }

    /**
     *
     * @param damageSource
     * @return hurt sound
     */
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.CAT_HURT;
    }

    /**
     *
     * @param pos
     * @param state
     */
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SHEEP_STEP,  0.15f, 1.0f);
    }

    @Override
    protected void tickLeash() {
        super.tickLeash();
    }

    @Override
    protected void customServerAiStep() {
        this.patrickTimer = this.eatGrassGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    @Override
    public void aiStep() {
        if (this.level.isClientSide) {
            this.patrickTimer = Math.max(0, this.patrickTimer - 1);
        }
        super.aiStep();
    }

    /**
     *
     * @param id
     */
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 10) {
            this.patrickTimer = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

}
