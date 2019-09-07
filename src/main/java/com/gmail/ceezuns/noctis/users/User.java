package com.gmail.ceezuns.noctis.users;

import com.gmail.ceezuns.noctis.users.cobble.CobbleManager;
import com.gmail.ceezuns.noctis.users.markers.MarkerManager;
import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.entity.Player;

public class User {

	private Player player;
	private ConfigurationFile configurationFile;
	private MarkerManager markerManager;
	private CobbleManager cobbleManager;

	public User(Player player) {
		this.player = player;
		this.configurationFile = new ConfigurationFile(this.player.getName());
		this.markerManager = new MarkerManager(this.configurationFile);
		this.cobbleManager = new CobbleManager(this.configurationFile);
	}

	public void load() {
		this.markerManager.load();
		this.cobbleManager.load();
	}

	public void save() {
		this.markerManager.save();
		this.cobbleManager.save();
	}

	public Player getPlayer() {
		return this.player;
	}

	public MarkerManager getMarkerManager() {
		return this.markerManager;
	}

	public CobbleManager getCobbleManager() {
		return this.cobbleManager;
	}
}