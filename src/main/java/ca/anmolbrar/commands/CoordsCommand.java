package ca.anmolbrar.commands;

import ca.anmolbrar.Noctis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoordsCommand implements CommandExecutor {

    public CoordsCommand() {
        Noctis.getInstance().getCommand("coords").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("coords")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            Player player = (Player) sender;
            Noctis.getInstance().getServer().broadcastMessage(ChatColor.GOLD + player.getName() + ChatColor.GRAY + " Coordinates " + ChatColor.DARK_GRAY + "> " + ChatColor.GOLD + player.getLocation().getBlockX() + ChatColor.GRAY + ", " + ChatColor.GOLD + player.getLocation().getBlockY() + ChatColor.GRAY + ", " + ChatColor.GOLD + player.getLocation().getBlockZ());
        }
        return true;
    }
}
