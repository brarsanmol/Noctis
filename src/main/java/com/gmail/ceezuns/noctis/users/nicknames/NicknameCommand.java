package com.gmail.ceezuns.noctis.users.nicknames;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import com.gmail.ceezuns.noctis.users.cobble.CobbleStatus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NicknameCommand implements CommandExecutor {

    public NicknameCommand() {
        Noctis.getInstance().getCommand("nickname").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (command.getName().equalsIgnoreCase("nickname")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You must be a player to perform this action");
            }

            User user = Noctis.getInstance().getUserManager().getUser((Player) sender);

            if (arguments.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "/nickname <string>" + ChatColor.GRAY + "- Change your nickname");
            } else {
                user.getNicknameManager().setNickname(arguments[0]);
                user.getPlayer().setDisplayName(arguments[0]);
                sender.sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Your nickname has now been changed to " + ChatColor.GOLD + arguments[0]);
            }
        }
        return true;
    }
}