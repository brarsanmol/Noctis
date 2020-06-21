package com.gmail.ceezuns.noctis.users.pin;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PinCommand implements CommandExecutor {

    public PinCommand() {
        Noctis.getInstance().getCommand("pin").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("pin")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);

            if (arguments.length == 0) {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Pin " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                sender.sendMessage(ChatColor.GOLD + "/pin create <string>" + ChatColor.GRAY + " - Create a pin");
                sender.sendMessage(ChatColor.GOLD + "/pin authenticate <string>" + ChatColor.GRAY + " - Authenticate with your pin");
                sender.sendMessage(ChatColor.GOLD + "/pin update <string>" + ChatColor.GRAY + " - Update a pin");
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Pin " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                return true;
            } else {
                switch (arguments[0].toLowerCase()) {
                    case "authenticate":
                        if (user.getPinManager().isAuthenticated()) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You are already authenticated");
                        } else if (arguments[1] == null) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/pin authenticate <string>");
                        } else if (user.getPinManager().getPin().equals(arguments[1])) {
                            user.getPinManager().setAuthenticated(true);
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You have been authenticated");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "The pin you provided, is invalid, please try again");
                        }
                        break;
                    case "create":
                        if (user.getPinManager().isAuthenticated()) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You are already authenticated");
                        } else if (arguments[1] == null) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/pin create <string>");
                        } else if (user.getPinManager().getPin() == null) {
                            user.getPinManager().setPin(arguments[1]);
                            user.getPinManager().setAuthenticated(true);
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Your pin has been created");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You already have a pin, to update your pin use the command " + ChatColor.GOLD + "/pin update <string>");
                        }
                        break;
                    case "update":
                        if (arguments[1] == null) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/pin update <string>");
                        } else {
                            user.getPinManager().setPin(arguments[1]);
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Your pin has been updated");
                        }
                        break;
                }
            }
        }
        return true;
    }

}
