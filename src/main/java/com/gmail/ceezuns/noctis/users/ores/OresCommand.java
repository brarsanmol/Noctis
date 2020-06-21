package com.gmail.ceezuns.noctis.users.ores;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OresCommand implements CommandExecutor {

    public OresCommand() {
        Noctis.getInstance().getCommand("ores").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("ores")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);
            sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Ores " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
            for (OreType ore : OreType.values()) {
                sender.sendMessage(ChatColor.GOLD + ore.getFriendlyName() + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + user.getOresManager().getAmountMined(ore));
            }
            sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Ores " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
        }
        return true;
    }
}
