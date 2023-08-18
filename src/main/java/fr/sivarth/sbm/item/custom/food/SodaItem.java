package fr.sivarth.sbm.item.custom.food;

import fr.sivarth.sbm.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SodaItem extends Item {

    public SodaItem() {
        super(new Item.Properties()
            .stacksTo(16)
            .tab(ModItemGroup.SBM_ITEM_GROUP)
            .food(new Food.Builder()
                .nutrition(7)
                .saturationMod(5.5f)
                .effect(new EffectInstance(Effects.MOVEMENT_SPEED, 500, 2), 2)
                .effect(new EffectInstance(Effects.ABSORPTION, 300, 0), 1)
                .effect(new EffectInstance(Effects.JUMP, 500, 2), 1)
                .alwaysEat()
                .build()));
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

}
