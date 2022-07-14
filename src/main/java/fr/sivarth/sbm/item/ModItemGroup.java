package fr.sivarth.sbm.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup SBM_ITEM_GROUP = new ItemGroup("spongeBobMod") {

        /**
         *
         * @return itemgroup icon
         */
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SPATULA.get());
        }
    };

}
