package fr.sivarth.sbm.item.custom.food;

import fr.sivarth.sbm.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class TomatoItem extends Item {

    public TomatoItem() {
        super(new Item.Properties()
            .stacksTo(64)
            .tab(ModItemGroup.SBM_ITEM_GROUP)
            .food(new Food.Builder()
                .nutrition(2)
                .saturationMod(1.0f)
                .build()));
    }
}
