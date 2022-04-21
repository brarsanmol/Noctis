package ca.anmolbrar.sets;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum SetType {

    WARRIOR("Warrior", 32, new Material[] {
            Material.DIAMOND_HELMET,
            Material.DIAMOND_CHESTPLATE,
            Material.DIAMOND_LEGGINGS,
            Material.DIAMOND_BOOTS
    }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 1),
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0),
    }),
    MINER("Miner", 48, new Material[]{
            Material.IRON_HELMET,
            Material.IRON_CHESTPLATE,
            Material.IRON_LEGGINGS,
            Material.IRON_BOOTS,
    }, new PotionEffect[]{
            new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1),
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1),
            new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1)
    }),
    EXPLORER("Explorer", 16, new Material[]{
            Material.LEATHER_HELMET,
            Material.LEATHER_CHESTPLATE,
            Material.LEATHER_LEGGINGS,
            Material.LEATHER_BOOTS,
    }, new PotionEffect[]{
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2),
            new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 1),
            new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, 1),
    });

    private String friendlyName;
    private int cost;
    private Material[] armor;
    private PotionEffect[] effects;

    SetType(String friendlyName, int cost, Material[] armor, PotionEffect[] effects) {
        this.friendlyName = friendlyName;
        this.cost = cost;
        this.armor = armor;
        this.effects = effects;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Material[] getArmor() {
        return armor;
    }

    public PotionEffect[] getEffects() {
        return effects;
    }

    public int getCost() {
        return cost;
    }
}
