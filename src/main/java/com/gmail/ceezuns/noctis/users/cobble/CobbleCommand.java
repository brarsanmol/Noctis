package com.gmail.ceezuns.noctis.users.cobble;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CobbleCommand implements CommandExecutor {

	private static Noctis instance = Noctis.getInstance();

	public CobbleCommand() {
		instance.getCommand("cobble").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		if (command.getName().equalsIgnoreCase("cobble")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
			}

			User user = instance.getUserManager().getUser((Player) sender);

			if (user.getCobbleManager().getCobbleStatus() == CobbleStatus.PICKUP) {
				user.getCobbleManager().setCobbleStatus(CobbleStatus.DO_NOT_PICKUP);
				sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You are now " + ChatColor.GOLD + "unable" + ChatColor.GRAY + " pickup cobblestone");
			} else {
				user.getCobbleManager().setCobbleStatus(CobbleStatus.PICKUP);
				sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You are now " + ChatColor.GOLD + "able" + ChatColor.GRAY + " pickup cobblestone");
			}
		}
		return true;
	}
}
