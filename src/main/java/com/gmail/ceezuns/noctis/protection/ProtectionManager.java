package com.gmail.ceezuns.noctis.protection;

import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;

public class ProtectionManager {


    private boolean protectionEnabled;
    private ConfigurationFile configurationFile;

    public ProtectionManager(ConfigurationFile configurationFile) {
        this.protectionEnabled = false;
        this.configurationFile = configurationFile;
    }

    public void load() {
        this.protectionEnabled = this.configurationFile.getConfiguration().getBoolean("protectionEnabled");
    }

    public void save() {
        this.configurationFile.getConfiguration().set("protectionEnabled", this.protectionEnabled);
        this.configurationFile.save();
    }

    public boolean isProtectionEnabled() {
        return this.protectionEnabled;
    }

    public void setProtectionEnabled(boolean protectionEnabled) {
        this.protectionEnabled = protectionEnabled;
    }
}
