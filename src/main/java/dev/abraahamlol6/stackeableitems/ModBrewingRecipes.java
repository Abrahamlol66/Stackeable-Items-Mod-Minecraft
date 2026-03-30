package dev.abraahamlol6.stackeableitems;

import dev.abraahamlol6.stackeableitems.mixin.BrewingRecipeRegistryAccessor;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

public class ModBrewingRecipes {
    public static void registerRecipes() {
        // Recetas para Nivel 3 (Poción Nivel 2 + Glowstone)
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_SWIFTNESS, Items.GLOWSTONE_DUST, ModPotions.SPEED_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_STRENGTH, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_REGENERATION, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_POISON, Items.GLOWSTONE_DUST, ModPotions.POISON_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_SLOWNESS, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_LEAPING, Items.GLOWSTONE_DUST, ModPotions.LEAPING_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_HEALING, Items.GLOWSTONE_DUST, ModPotions.HEALING_III);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRONG_HARMING, Items.GLOWSTONE_DUST, ModPotions.HARMING_III);

        // Recetas para Duración Extendida 12 min (Poción Base + Redstone)
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.NIGHT_VISION, Items.REDSTONE, ModPotions.LONG_NIGHT_VISION);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.INVISIBILITY, Items.REDSTONE, ModPotions.LONG_INVISIBILITY);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.FIRE_RESISTANCE, Items.REDSTONE, ModPotions.LONG_FIRE_RESISTANCE);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.WATER_BREATHING, Items.REDSTONE, ModPotions.LONG_WATER_BREATHING);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.WEAKNESS, Items.REDSTONE, ModPotions.LONG_WEAKNESS);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.SLOW_FALLING, Items.REDSTONE, ModPotions.LONG_SLOW_FALLING);
        
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.SWIFTNESS, Items.REDSTONE, ModPotions.LONG_SPEED_12);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.STRENGTH, Items.REDSTONE, ModPotions.LONG_STRENGTH_12);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.REGENERATION, Items.REDSTONE, ModPotions.LONG_REGENERATION_12);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.POISON, Items.REDSTONE, ModPotions.LONG_POISON_12);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.LEAPING, Items.REDSTONE, ModPotions.LONG_LEAPING_12);
    }
}
