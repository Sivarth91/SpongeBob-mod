package fr.sivarth.sbm.item.custom;

import fr.sivarth.sbm.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class KrustyPattyItem extends Item {

    public KrustyPattyItem() {
        super(new Item.Properties()
            .tab(ModItemGroup.SBM_ITEM_GROUP)
            .food(new Food.Builder()
                .nutrition(6)
                .saturationMod(2.2f)
                .effect(new EffectInstance(Effects.ABSORPTION, 200, 1), 1)
                .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 100, 0), 1)
                .effect(new EffectInstance(Effects.MOVEMENT_SPEED, 150, 1), 1)
                .effect(new EffectInstance(Effects.HEAL, 200, 1), 1)
                .alwaysEat()
                .build())
        );
    }
}
