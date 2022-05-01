package ca.anmolbrar.users.markers;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("markers")
public class MarkersCommand extends BaseCommand {

	public MarkersCommand() {
		Noctis.getInstance().getCommandManager().registerCommand(this);
	}

	@HelpCommand
	public static void onHelp(CommandSender sender) {
		sender.sendMessage(new String[] {
				"",
				ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Markers Help",
				"",
				ChatColor.GRAY + " <> = Required Argument",
				ChatColor.GRAY + " [] = Optional Argument",
				"",
				CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/markers list" + ChatColor.GRAY + " - " + ChatColor.WHITE + "List all markers",
				CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/markers add <name>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Add a marker",
				CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/markers remove <name>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Remove a marker",
				CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/markers update <name>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Update a marker",
				""
		});
	}

	@Subcommand("list")
	public static void onList(Player player, User user) {
		var markers = user.getMarkerManager().getMarkers();

		if (markers.isEmpty()) {
			player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "You currently have no markers.");
		} else {
			player.sendMessage(new String[] {
					"",
					ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Markers",
					"",
			});
			markers.forEach(marker -> player.sendMessage(" " + ChatColor.WHITE + marker.getName()
					+ ChatColor.GRAY + "("
					+ ChatColor.LIGHT_PURPLE + marker.getLocation().getX() + ChatColor.GRAY + ", "
					+ ChatColor.LIGHT_PURPLE + marker.getLocation().getY() + ChatColor.GRAY + ", "
					+ ChatColor.LIGHT_PURPLE + marker.getLocation().getZ() + ChatColor.GRAY + ")"));
			player.sendMessage();
		}
	}

	@Subcommand("add")
	public static void onAdd(Player player, User user, String name) {
		if (user.getMarkerManager().getMarker(name) == null) {
			user.getMarkerManager().addMarker(new Marker(name, user.getPlayer().getLocation()));
			player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "The marker " + name + " has been added.");
		} else {
			player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "A marker with the name " + name + " already exists.");
		}
	}

	@Subcommand("remove")
	public static void onRemove(Player player, User user, String name) {
		if (user.getMarkerManager().getMarker(name) != null) {
			user.getMarkerManager().removeMarker(user.getMarkerManager().getMarker(name));
			player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "The marker " + name + " has been removed.");
		} else {
			player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "A marker with the name " + name + " does not exist.");
		}
	}

	@Subcommand("update")
	public static void onUpdate(Player player, User user, String name) {
		if (user.getMarkerManager().getMarker(name) != null) {
			user.getMarkerManager().getMarker(name).setLocation(user.getPlayer().getLocation());
			player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "The marker " + name + " has been updated.");
		} else {
			player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "A marker with the name " + name + " does not exist.");
		}
	}
}
