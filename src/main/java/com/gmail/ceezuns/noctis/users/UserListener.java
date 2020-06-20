package com.gmail.ceezuns.noctis.users;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserListener implements Listener {

	private static Noctis instance = Noctis.getInstance();

	public UserListener() {
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		User user = new User(event.getPlayer());
		user.load();
		instance.getUserManager().addUser(user);
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		User user = instance.getUserManager().getUser(event.getPlayer());
		user.save();
		instance.getUserManager().removeUser(user);
	}
}
