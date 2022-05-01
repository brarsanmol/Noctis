package ca.anmolbrar.users;

import ca.anmolbrar.Noctis;
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

		event.getPlayer().sendMessage(new String[] {
				"",
				ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "WELCOME!",
				"",
		});

		if (user.getPinManager().getPin() == null) {
			event.getPlayer().sendMessage(new String[] {
					" Please use the " + ChatColor.LIGHT_PURPLE + "/pin create <string>" + ChatColor.GRAY + " command to create a pin and secure your account!",
					" Please do not use anything that you would for any other accounts."
			});
		} else {
			event.getPlayer().sendMessage(" Please authenticate with the " + ChatColor.LIGHT_PURPLE + "/pin authenticate <string>" + ChatColor.GRAY + " command.");
		}
		event.getPlayer().sendMessage();
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		User user = instance.getUserManager().getUser(event.getPlayer());
		user.save();
		instance.getUserManager().removeUser(user);
	}
}
