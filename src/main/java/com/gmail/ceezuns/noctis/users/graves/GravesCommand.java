package com.gmail.ceezuns.noctis.users.graves;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import com.gmail.ceezuns.noctis.users.cobble.CobbleStatus;
import com.gmail.ceezuns.noctis.users.markers.Marker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GravesCommand implements CommandExecutor {

    public GravesCommand() {
        Noctis.getInstance().getCommand("graves").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("graves")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);
            if (user.getGravesManager().getGraves().isEmpty()) {
                sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You currently have no graves");
            } else {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Graves " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                sender.sendMessage("");
                for (Grave grave : user.getGravesManager().getGraves()) {
                    sender.sendMessage(ChatColor.GOLD + "Timestamp" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getTimestamp());
                    sender.sendMessage(ChatColor.GOLD + "Death Cause" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getDeathCause());
                    sender.sendMessage(ChatColor.GOLD + "Location" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getLocation().getWorld().getName() + ", " + grave.getLocation().getX() + ", " + grave.getLocation().getY() + ", " + grave.getLocation().getZ());
                    sender.sendMessage("");
                }
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Graves " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
            }
        }
        return true;
    }

}
