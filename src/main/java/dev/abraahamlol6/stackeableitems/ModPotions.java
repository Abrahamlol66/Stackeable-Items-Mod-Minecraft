package dev.abraahamlol6.stackeableitems;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    // Nivel 3 (Amplificador 2) - Se define con 1:30 (1800 ticks)
    public static final Potion SPEED_III = register("speed_iii", new Potion("speed", new StatusEffectInstance(StatusEffects.SPEED, 1800, 2)));
    public static final Potion STRENGTH_III = register("strength_iii", new Potion("strength", new StatusEffectInstance(StatusEffects.STRENGTH, 1800, 2)));
    public static final Potion REGENERATION_III = register("regeneration_iii", new Potion("regeneration", new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 2)));
    public static final Potion POISON_III = register("poison_iii", new Potion("poison", new StatusEffectInstance(StatusEffects.POISON, 1800, 2)));
    public static final Potion SLOWNESS_III = register("slowness_iii", new Potion("slowness", new StatusEffectInstance(StatusEffects.SLOWNESS, 1800, 2)));
    public static final Potion LEAPING_III = register("leaping_iii", new Potion("jump_boost", new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1800, 2)));
    public static final Potion HEALING_III = register("healing_iii", new Potion("healing", new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 2)));
    public static final Potion HARMING_III = register("harming_iii", new Potion("harming", new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 2)));

    // Duración Extendida - Usando duración Long Vanilla (8:00 = 9600 ticks)
    public static final Potion LONG_NIGHT_VISION = register("long_night_vision_12", new Potion("night_vision", new StatusEffectInstance(StatusEffects.NIGHT_VISION, 9600)));
    public static final Potion LONG_INVISIBILITY = register("long_invisibility_12", new Potion("invisibility", new StatusEffectInstance(StatusEffects.INVISIBILITY, 9600)));
    public static final Potion LONG_FIRE_RESISTANCE = register("long_fire_resistance_12", new Potion("fire_resistance", new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600)));
    public static final Potion LONG_WATER_BREATHING = register("long_water_breathing_12", new Potion("water_breathing", new StatusEffectInstance(StatusEffects.WATER_BREATHING, 9600)));
    public static final Potion LONG_WEAKNESS = register("long_weakness_12", new Potion("weakness", new StatusEffectInstance(StatusEffects.WEAKNESS, 9600)));
    public static final Potion LONG_SLOW_FALLING = register("long_slow_falling_12", new Potion("slow_falling", new StatusEffectInstance(StatusEffects.SLOW_FALLING, 9600)));
    
    // Versiones Extendidas de niveles 1 (8:00 Vanilla)
    public static final Potion LONG_SPEED_12 = register("long_speed_12", new Potion("speed", new StatusEffectInstance(StatusEffects.SPEED, 9600)));
    public static final Potion LONG_STRENGTH_12 = register("long_strength_12", new Potion("strength", new StatusEffectInstance(StatusEffects.STRENGTH, 9600)));
    public static final Potion LONG_REGENERATION_12 = register("long_regeneration_12", new Potion("regeneration", new StatusEffectInstance(StatusEffects.REGENERATION, 9600)));
    public static final Potion LONG_POISON_12 = register("long_poison_12", new Potion("poison", new StatusEffectInstance(StatusEffects.POISON, 9600)));
    public static final Potion LONG_LEAPING_12 = register("long_leaping_12", new Potion("jump_boost", new StatusEffectInstance(StatusEffects.JUMP_BOOST, 9600)));

    private static Potion register(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(StackeableItemsMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        StackeableItemsMod.LOGGER.info("Registering custom potions for " + StackeableItemsMod.MOD_ID);
    }
}
