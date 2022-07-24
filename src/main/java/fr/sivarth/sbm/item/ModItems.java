package fr.sivarth.sbm.item;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.block.ModBlocks;
import fr.sivarth.sbm.entity.ModEntityTypes;
import fr.sivarth.sbm.item.custom.food.KrabbyPattyItem;
import fr.sivarth.sbm.item.custom.ModSpawnEggItem;
import fr.sivarth.sbm.item.custom.SpatulaItem;
import fr.sivarth.sbm.item.custom.food.PineappleItem;
import fr.sivarth.sbm.item.custom.food.SodaItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SBM.MODID);

    // items
    public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula", () -> new SpatulaItem(new Item.Properties().stacksTo(1).fireResistant().tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_PLATE = ITEMS.register("aluminium_plate", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> BANKNOTE = ITEMS.register("banknote", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> CASH_REGISTER_SCREEN = ITEMS.register("cash_register_screen", () -> new Item(new Item.Properties().stacksTo(16).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> CASH_REGISTER_BUTTON = ITEMS.register("cash_register_button", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> HOTPLATE = ITEMS.register("hotplate", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> PAVING_STONE = ITEMS.register("paving_stone", () -> new Item(new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> KRABBY_PATTY_SECRET_RECIPE = ITEMS.register("krabby_patty_secret_recipe", () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));


    // tools
    public static final RegistryObject<Item> ALUMINIUM_SWORD = ITEMS.register("aluminium_sword", () -> new SwordItem(CustomItemTiers.ALUMINIUM, 4, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_PICKAXE = ITEMS.register("aluminium_pickaxe", () -> new PickaxeItem(CustomItemTiers.ALUMINIUM, 4, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_AXE = ITEMS.register("aluminium_axe", () -> new AxeItem(CustomItemTiers.ALUMINIUM, 4, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_HOE = ITEMS.register("aluminium_hoe", () -> new HoeItem(CustomItemTiers.ALUMINIUM, 4, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<Item> ALUMINIUM_SHOVEL = ITEMS.register("aluminium_shovel", () -> new ShovelItem(CustomItemTiers.ALUMINIUM, 4, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroup.SBM_ITEM_GROUP)));

    // food
    public static final RegistryObject<KrabbyPattyItem> KRABBY_PATTY = ITEMS.register("krabby_patty", KrabbyPattyItem::new);
    public static final RegistryObject<PineappleItem> PINEAPPLE = ITEMS.register("pineapple", PineappleItem::new);
    public static final RegistryObject<SodaItem> SODA = ITEMS.register("soda", SodaItem::new);
    public static final RegistryObject<Item> ONIONS = ITEMS.register("onions", () -> new BlockItem(ModBlocks.ONIONS.get(), new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP).food(new Food.Builder().nutrition(1).saturationMod(0.1f).alwaysEat().fast().build())));

    // armors


    // spawn eggs
    public static final RegistryObject<ModSpawnEggItem> SPONGE_BOB_SPAWN_EGG = ITEMS.register("sponge_bob_spawn_egg", () -> new ModSpawnEggItem(ModEntityTypes.SPONGE_BOB, 0xFFF244, 0x716D44, new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<ModSpawnEggItem> PATRICK_SPAWN_EGG = ITEMS.register("patrick_spawn_egg", () -> new ModSpawnEggItem(ModEntityTypes.PATRICK, 0xFF808B, 0x176128, new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<ModSpawnEggItem> GARY_SPAWN_EGG = ITEMS.register("gary_spawn_egg", () -> new ModSpawnEggItem(ModEntityTypes.GARY, 0xD5A4DA, 0xA4DAD9, new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));
    public static final RegistryObject<ModSpawnEggItem> PLANKTON_SPAWN_EGG = ITEMS.register("plankton_spawn_egg", () -> new ModSpawnEggItem(ModEntityTypes.PLANKTON, 0x29552D, 0xE4CF8C, new Item.Properties().stacksTo(64).tab(ModItemGroup.SBM_ITEM_GROUP)));

}
