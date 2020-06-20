package com.gmail.ceezuns.noctis.users.markers;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MarkersCommand implements CommandExecutor {

	private static Noctis instance = Noctis.getInstance();

	public MarkersCommand() {
		instance.getCommand("markers").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		if (command.getName().equalsIgnoreCase("markers")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
			}

			User user = instance.getUserManager().getUser((Player) sender);

			if (arguments.length == 0) {
				sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Markers " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
				sender.sendMessage(ChatColor.GOLD + "/markers list" + ChatColor.GRAY + " - List all markers");
				sender.sendMessage(ChatColor.GOLD + "/markers add <name>" + ChatColor.GRAY + " - Add a marker");
				sender.sendMessage(ChatColor.GOLD + "/markers remove <name>" + ChatColor.GRAY + " - Remove a marker");
				sender.sendMessage(ChatColor.GOLD + "/markers update <name>" + ChatColor.GRAY + " - Update a marker");
				sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Markers " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
				return true;
			} else {
				switch (arguments[0].toLowerCase()) {
					case "list":
						if (user.getMarkerManager().getMarkers().isEmpty()) {
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You currently have no markers");
						} else {
							sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Markers " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
							user.getMarkerManager().getMarkers().forEach(marker -> user.getPlayer().sendMessage(ChatColor.GOLD + marker.getName() + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + marker.getLocation().getX() + ", " + marker.getLocation().getY() + ", " + marker.getLocation().getZ()));
							sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Markers " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
						}
						break;
					case "add":
						if (arguments[1] == null) {
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/markers add <name>");
						} else if (user.getMarkerManager().getMarker(arguments[1]) == null) {
							user.getMarkerManager().addMarker(new Marker(arguments[1], user.getPlayer().getLocation()));
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "The marker " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " has been added");
						} else {
							sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "A marker with the name " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " already exists");
						}
						break;
					case "remove":
						if (arguments[1] == null) {
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/markers remove <name>");
						} else if (user.getMarkerManager().getMarker(arguments[1]) != null) {
							user.getMarkerManager().removeMarker(user.getMarkerManager().getMarker(arguments[1]));
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "The marker " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " has been removed");
						} else {
							sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "A marker with the name " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " does not exist");
						}
						break;
					case "update":
						if (arguments[1] == null) {
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/markers update <name>");
						} else if (user.getMarkerManager().getMarker(arguments[1]) != null) {
							user.getMarkerManager().getMarker(arguments[1]).setLocation(user.getPlayer().getLocation());
							sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "The marker " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " has been updated");
						} else {
							sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "A marker with the name " + ChatColor.GOLD + arguments[1] + ChatColor.GRAY + " does not exist");
						}
						break;
				}
			}
		}
		return true;
	}
}
