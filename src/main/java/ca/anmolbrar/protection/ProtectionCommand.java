package ca.anmolbrar.protection;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProtectionCommand implements CommandExecutor {

    public ProtectionCommand() {
        Noctis.getInstance().getCommand("protection").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("protection")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            if (!sender.hasPermission("protection.command")) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You do not have permission to perform this action");
                return false;
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);
            if (arguments.length == 0) {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Protection " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                sender.sendMessage(ChatColor.GOLD + "/protection on" + ChatColor.GRAY + " - Turn on protection");
                sender.sendMessage(ChatColor.GOLD + "/protection off" + ChatColor.GRAY + " - Turn off protection");
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Protection " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
                return true;
            } else {
                switch (arguments[0].toLowerCase()) {
                    case "on":
                        Noctis.getInstance().getProtectionManager().setProtectionEnabled(true);
                        Noctis.getInstance().getServer().broadcastMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Protection is now enabled, you will be immune from entity damage and hunger level changes.");
                        break;
                    case "off":
                        Noctis.getInstance().getProtectionManager().setProtectionEnabled(false);
                        Noctis.getInstance().getServer().broadcastMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Protection is now disabled, you will no longer be immune from entity damage and hunger level changes.");
                        break;
                }
            }
        }
        return true;
    }

}
