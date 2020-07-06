package com.gmail.ceezuns.noctis.users;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.ChatColor;
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

		if (user.getNicknameManager().getNickname() == null) {
			user.getNicknameManager().setNickname(event.getPlayer().getName());
		} else {
			event.getPlayer().setDisplayName(user.getNicknameManager().getNickname());
		}

		if (user.getPinManager().getPin() == null) {
			user.getPlayer().sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Welcome, please use the " + ChatColor.GOLD + "/pin create <string>" + ChatColor.GRAY + " command to create a pin and secure your account!");
			user.getPlayer().sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "DO NOT USE ANYTHING THAT YOU WOULD USE FOR YOUR OTHER ACCOUNT!");
		} else {
			user.getPlayer().sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Please authenticate with the " + ChatColor.GOLD + "/pin authenticate <string> " + ChatColor.GRAY + " command");
		}
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		User user = instance.getUserManager().getUser(event.getPlayer());
		user.save();
		instance.getUserManager().removeUser(user);
	}
}
