package com.gmail.ceezuns.noctis.users.ores;

import org.bukkit.Material;

public enum OreType {

    ANCIENT_DEBRIS(Material.ANCIENT_DEBRIS, "Ancient Debris"),
    EMERALD_ORE(Material.EMERALD_ORE, "Emerald Ore"),
    DIAMOND_ORE(Material.DIAMOND_ORE, "Diamond Ore"),
    REDSTONE_ORE(Material.REDSTONE_ORE, "Redstone Ore"),
    GOLD_ORE(Material.GOLD_ORE, "Gold Ore"),
    NETHER_GOLD_ORE(Material.NETHER_GOLD_ORE, "Nether Gold Ore"),
    LAPIS_ORE(Material.LAPIS_ORE, "Lapis Ore"),
    IRON_ORE(Material.IRON_ORE, "Iron Ore"),
    COAL_ORE(Material.COAL_ORE, "Coal Ore");

    private Material ore;
    private String friendlyName;

    OreType(Material ore, String friendlyName) {
        this.ore = ore;
        this.friendlyName = friendlyName;
    }

    public Material getOre() {
        return this.ore;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }
}
