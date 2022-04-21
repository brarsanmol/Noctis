package ca.anmolbrar.sets;

import ca.anmolbrar.utilities.ConfigurationFile;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class SetsManager {

    private List<SetType> sets;
    private ConfigurationFile configurationFile;
    private SetType activatedSet;

    public SetsManager(ConfigurationFile configurationFile) {
        this.activatedSet = null;
        this.sets = new ArrayList<>();
        this.configurationFile = configurationFile;
    }

    public boolean addSet(SetType set) {
        return this.sets.add(set);
    }

    public boolean removeSet(SetType set) {
        return this.sets.remove(set);
    }

    public boolean containsSet(String name) {
        return this.sets.contains(SetType.valueOf(name.toUpperCase()));
    }

    public SetType getActivatedSet() {
        return activatedSet;
    }

    public void setActivatedSet(SetType activatedSet) {
        this.activatedSet = activatedSet;
    }

    public void load() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("sets");
        if (section == null) {
            return;
        } else {
            for (SetType set : SetType.values()) {
                if (section.getBoolean(set.name())) {
                    this.sets.add(set);
                }
            }
        }
    }

    public void save() {
        ConfigurationSection section = this.configurationFile.getConfiguration().createSection("sets");
        for (SetType set : SetType.values()) {
            section.set(set.name(), this.sets.contains(set));
        }
        this.configurationFile.save();
    }

    public List<SetType> getSets() {
        return sets;
    }
}
