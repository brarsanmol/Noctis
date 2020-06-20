package com.gmail.ceezuns.noctis;

import com.gmail.ceezuns.noctis.users.UserListener;
import com.gmail.ceezuns.noctis.users.UserManager;
import com.gmail.ceezuns.noctis.users.cobble.CobbleCommand;
import com.gmail.ceezuns.noctis.users.cobble.CobbleListener;
import com.gmail.ceezuns.noctis.users.graves.GravesCommand;
import com.gmail.ceezuns.noctis.users.graves.GravesListener;
import com.gmail.ceezuns.noctis.users.markers.MarkersCommand;
import com.gmail.ceezuns.noctis.users.pin.PinCommand;
import com.gmail.ceezuns.noctis.users.pin.PinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noctis extends JavaPlugin {

	private static Noctis instance;
	private UserManager userManager;

	@Override
	public void onEnable() {
		instance = this;
		this.userManager = new UserManager();
		new UserListener();
		new CobbleListener();
		new GravesListener();
		new PinListener();
		new MarkersCommand();
		new CobbleCommand();
		new GravesCommand();
		new PinCommand();
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
