package com.gmail.ceezuns.noctis.users.ores;

import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class OresManager {

    private HashMap<OreType, Integer> ores;
    private ConfigurationFile configurationFile;

    public OresManager(ConfigurationFile configurationFile) {
        this.ores = new HashMap<>();
        this.configurationFile = configurationFile;
    }

    public void load() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("ores");
        if (section == null) {
            return;
        } else {
            section.getKeys(false).forEach(ore -> {
                this.ores.put(OreType.valueOf(ore), section.getInt(ore));
            });
        }
    }

    public void save() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("ore");
        if (section == null) {
            return;
        } else {
            this.ores.forEach((ore, value) -> section.set(ore.name(), value));
        }

        this.configurationFile.save();
        this.clearOres();
    }

    /**
     * This is inefficient because this is called for every block mined.
     * We should also attempt to mark blocks so duplicated mining is not logged (i.e mine with silk touch pickaxe, and then mine with fortune after)
     */
    public void incrementOreMined(OreType ore) {
        this.ores.put(ore, this.ores.getOrDefault(ore, 0) + 1);
    }

    public void decrementOreMined(OreType ore) {
        this.ores.put(ore, this.ores.get(ore) - 1);
    }

    public void clearOres() {
        this.ores.clear();
    }

    public int getAmountMined(OreType ore) {
        return this.ores.getOrDefault(ore, 0);
    }

    public HashMap<OreType, Integer> getOres() {
        return this.ores;
    }
}
