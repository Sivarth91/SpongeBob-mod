package fr.sivarth.sbm.item.custom.food;

import fr.sivarth.sbm.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class KrabbyPattyItem extends Item {

    public KrabbyPattyItem() {
        super(new Item.Properties()
            .tab(ModItemGroup.SBM_ITEM_GROUP)
            .food(new Food.Builder()
                .nutrition(8)
                .saturationMod(4.2f)
                .effect(new EffectInstance(Effects.ABSORPTION, 400, 1), 1)
                .effect(new EffectInstance(Effects.HEAL, 400, 0), 1)
                .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 300, 1), 1)
                .alwaysEat()
                .build()));
    }



}
