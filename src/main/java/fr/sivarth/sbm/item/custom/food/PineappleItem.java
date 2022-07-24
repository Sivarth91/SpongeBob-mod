package fr.sivarth.sbm.item.custom.food;

import fr.sivarth.sbm.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class PineappleItem extends Item {

    public PineappleItem() {
        super(new Item.Properties()
            .stacksTo(64)
            .tab(ModItemGroup.SBM_ITEM_GROUP)
            .food(new Food.Builder()
                .nutrition(5)
                .saturationMod(2.2f)
                .alwaysEat()
                .build()));
    }
}
