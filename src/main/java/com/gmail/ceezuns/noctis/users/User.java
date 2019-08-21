package com.gmail.ceezuns.noctis.users;

import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.entity.Player;

public class User {

	private Player player;
	private ConfigurationFile configurationFile;

	public User(Player player) {
		this.player = player;
		this.configurationFile = new ConfigurationFile(this.player.getName());
	}

	public void load() {
	}

	public void save() {
	}

	public Player getPlayer() {
		return this.player;
	}
}
