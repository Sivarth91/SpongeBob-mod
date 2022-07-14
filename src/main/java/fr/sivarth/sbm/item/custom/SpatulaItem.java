package fr.sivarth.sbm.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class SpatulaItem extends Item {

    public SpatulaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getPlayer().getCommandSenderWorld();
        return super.onItemUseFirst(stack, context);
    }


    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return super.canElytraFly(stack, entity);
    }


}
