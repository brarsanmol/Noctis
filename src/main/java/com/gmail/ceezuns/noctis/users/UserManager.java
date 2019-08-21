package com.gmail.ceezuns.noctis.users;

import org.bukkit.entity.Player;

import java.util.HashSet;

public class UserManager {

	private HashSet<User> users;

	public UserManager() {
		this.users = new HashSet<>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void removeUser(User user) {
		this.users.remove(user);
	}

	public User getUser(Player player) {
		return this.users.stream().filter(user -> user.getPlayer().getUniqueId().equals(player.getUniqueId())).findFirst().orElse(null);
	}

	public void clearUsers() {
		this.users.clear();
	}
}
