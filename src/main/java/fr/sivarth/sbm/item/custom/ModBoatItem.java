package fr.sivarth.sbm.item.custom;

import fr.sivarth.sbm.entity.custom.ModBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class ModBoatItem extends BoatItem {

    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::canBeCollidedWith);
    private final String woodType;

    public ModBoatItem(Properties properties, String woodType) {
        super(null, properties);
        this.woodType = woodType;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        RayTraceResult rayTraceResult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);

        if (rayTraceResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemStack);
        } else {
            Vector3d vector3d = playerIn.getViewVector(1.0f);
            double d0 = 5.0D;
            List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vector3d vector3d1 = playerIn.getViewVector(1.0f);

                for (Entity entity: list) {
                    AxisAlignedBB axisAlignedBB = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (axisAlignedBB.contains(vector3d1)) {
                        return ActionResult.pass(itemStack);
                    }
                }
            }

            if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
                ModBoatEntity boatEntity = new ModBoatEntity(worldIn, rayTraceResult.getLocation().x, rayTraceResult.getLocation().y, rayTraceResult.getLocation().z);
                boatEntity.setWoodType(woodType);
                boatEntity.yRot = playerIn.yRot;

                if (!worldIn.noCollision(boatEntity, boatEntity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemStack);
                } else {
                    if (!worldIn.isClientSide()) {
                        worldIn.addFreshEntity(boatEntity);
                        if (!playerIn.abilities.instabuild) {
                            itemStack.shrink(1);
                        }
                    }
                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(itemStack, worldIn.isClientSide());
                }
            } else {
                return ActionResult.pass(itemStack);
            }
        }
    }
}
