package com.gmail.ceezuns.noctis.users.nicknames;

import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.ChatColor;

public class NicknameManager {

    //TODO: Add ability to have multiple nicknames.
    private String nickname;
    private ConfigurationFile configurationFile;

    public NicknameManager(ConfigurationFile configurationFile) {
        this.configurationFile = configurationFile;
    }

    public void load() {
        this.nickname = this.configurationFile.getConfiguration().getString("nickname");
    }

    public void save() {
        this.configurationFile.getConfiguration().set("nickname", this.nickname);

        this.configurationFile.save();
        this.nickname = null;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
