package com.gmail.ceezuns.noctis;

import com.gmail.ceezuns.noctis.users.UserListener;
import com.gmail.ceezuns.noctis.users.UserManager;
import com.gmail.ceezuns.noctis.users.markers.MarkersCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noctis extends JavaPlugin {

	private static Noctis instance;
	private UserManager userManager;

	@Override
	public void onEnable() {
		instance = this;
		this.userManager = new UserManager();
		new UserListener();
		new MarkersCommand();
	}

	@Override
	public void onDisable() {
		this.userManager.clearUsers();
		this.userManager = null;
		instance = null;
	}

	public static Noctis getInstance() {
		return instance;
	}

	public UserManager getUserManager() {
		return this.userManager;
	}
}
