package com.gmail.ceezuns.noctis.users.pin;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.markers.Marker;
import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PinManager {

    private String pin;
    private boolean authenticated;
    private ConfigurationFile configurationFile;

    public PinManager(ConfigurationFile configurationFile) {
        this.authenticated = false;
        this.configurationFile = configurationFile;
    }

    public void load() {
        this.pin = this.configurationFile.getConfiguration().getString("pin");
    }

    public void save() {
        this.configurationFile.getConfiguration().set("pin", this.pin);
        this.configurationFile.save();
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
