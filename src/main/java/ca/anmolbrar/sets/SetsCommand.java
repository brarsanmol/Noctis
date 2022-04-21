package ca.anmolbrar.sets;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetsCommand implements CommandExecutor {

    public SetsCommand() {
        Noctis.getInstance().getCommand("sets").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("sets")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);
            if (arguments.length == 0) {
                Noctis.getInstance().getHera().getInventoryManager().getInventory("sets").show(user.getPlayer());
            } else {
                switch (arguments[0].toLowerCase()) {
                    case "help":
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Sets " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                        sender.sendMessage(ChatColor.GOLD + "/sets list" + ChatColor.GRAY + " - List all sets");
                        sender.sendMessage(ChatColor.GOLD + "/sets unlock <name>" + ChatColor.GRAY + " - Unlock a set");
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Sets " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                        break;
                    case "list":
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Sets " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                        for (SetType set : SetType.values()) {
                            if (user.getSetsManager().getSets().contains(set)) {
                                sender.sendMessage(ChatColor.GRAY + set.getFriendlyName() + ChatColor.DARK_GRAY + " - " + ChatColor.GREEN + " Unlocked");
                            } else {
                                sender.sendMessage(ChatColor.GRAY + set.getFriendlyName() + ChatColor.DARK_GRAY + " - " + ChatColor.RED + " Locked");
                            }
                        }
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Sets " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                        break;
                    case "unlock":
                        if (arguments[1].length() < 1) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "Usage: " + ChatColor.GOLD + "/sets unlock <name>");
                        } else if (SetType.valueOf(arguments[1].toUpperCase()) == null) {
                            sender.sendMessage(ChatColor.GOLD + "Server" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "A set with the name of " + ChatColor.GOLD +  arguments[1] + ChatColor.GRAY + " does not exist");
                        } else if (user.getSetsManager().containsSet(arguments[1])) {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You have already unlocked this set");
                        } else if (user.getPlayer().getInventory().getItemInMainHand().getType() != Material.DIAMOND) {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "To unlock this set you must hold diamonds in your main hand");
                        } else if (user.getPlayer().getInventory().getItemInMainHand().getAmount() < SetType.valueOf(arguments[1].toUpperCase()).getCost()) {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "To unlock this set you must have " + ChatColor.GOLD + SetType.valueOf(arguments[1].toUpperCase()).getCost() + ChatColor.GRAY + " diamonds");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + "You have unlocked the " + ChatColor.GOLD + SetType.valueOf(arguments[1].toUpperCase()).getFriendlyName() + ChatColor.GRAY + " set");
                            user.getPlayer().getInventory().getItemInMainHand().setAmount(user.getPlayer().getInventory().getItemInMainHand().getAmount() - SetType.valueOf(arguments[1].toUpperCase()).getCost());
                            user.getSetsManager().addSet(SetType.valueOf(arguments[1].toUpperCase()));
                        }
                        break;
                }
            }
        }
        return true;
    }
}
