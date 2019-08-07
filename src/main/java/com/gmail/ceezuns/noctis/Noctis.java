package com.gmail.ceezuns.noctis;

import org.bukkit.plugin.java.JavaPlugin;

public final class Noctis extends JavaPlugin {

	private static Noctis instance;

	@Override
	public void onEnable() {
		instance = this;
	}

	@Override
	public void onDisable() {
		instance = null;
	}

	public static Noctis getInstance() {
		return instance;
	}
}
