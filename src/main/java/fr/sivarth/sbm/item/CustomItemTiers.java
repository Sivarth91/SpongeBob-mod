package fr.sivarth.sbm.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CustomItemTiers implements IItemTier {

    ALUMINIUM(2, 230, 4.5f, 3, 20, new LazyValue<>(() -> {
        return Ingredient.of(ModItems.ALUMINIUM_INGOT.get());
    }));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    /**
     *
     * @param level
     * @param uses
     * @param speed
     * @param damage
     * @param enchantmentValue
     * @param repairIngredient
     */
    CustomItemTiers(int level, int uses, float speed, float damage, int enchantmentValue, LazyValue<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    /**
     *
     * @return uses
     */
    @Override
    public int getUses() {
        return uses;
    }

    /**
     *
     * @return speed
     */
    @Override
    public float getSpeed() {
        return speed;
    }

    /**
     *
     * @return damage
     */
    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    /**
     *
     * @return level
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     *
     * @return enchantment value
     */
    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    /**
     *
     * @return repair ingredient
     */
    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

}
