package com.gmail.ceezuns.noctis.users.graves;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Date;
import java.util.HashSet;

public class GravesManager {

    private HashSet<Grave> graves;
    private ConfigurationFile configurationFile;

    public GravesManager(ConfigurationFile configurationFile) {
        this.graves = new HashSet<>();
        this.configurationFile = configurationFile;
    }

    public void load() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("graves");
        if (section == null) {
            return;
        } else {
            section.getKeys(false).forEach(grave -> {
                this.graves.add(new Grave(grave, section.getString("death-cause"), new Location(Noctis.getInstance().getServer().getWorld(section.getString(grave + ".world")), section.getInt(grave + ".x"), section.getInt(grave + ".y"), section.getInt(grave + ".z"))));
            });
        }
    }

    public void save() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("graves");
        if (section == null) {
            return;
        } else {
            this.graves.forEach(grave -> {
                section.set(grave.getTimestamp() + ".death-cause", grave.getDeathCause());
                section.set(grave.getTimestamp() + ".world", grave.getLocation().getWorld().getName());
                section.set(grave.getTimestamp() + ".x", grave.getLocation().getBlockX());
                section.set(grave.getTimestamp() + ".y", grave.getLocation().getBlockY());
                section.set(grave.getTimestamp() + ".z", grave.getLocation().getBlockZ());
            });
            section.getKeys(false).forEach(grave -> {
                if (this.getGrave(grave) == null) {
                    section.set(grave, null);
                }
            });
        }

        this.configurationFile.save();
        this.clearGraves();
    }

    public void addGrave(Grave grave) {
        this.graves.add(grave);
    }

    public void removeGrave(Grave Grave) {
        this.graves.remove(Grave);
    }

    public void clearGraves() {
        this.graves.clear();
    }

    public Grave getGrave(String timestamp) {
        return this.graves.stream().filter(grave -> grave.getTimestamp().equals(timestamp)).findFirst().orElse(null);
    }

    public HashSet<Grave> getGraves() {
        return this.graves;
    }
}
