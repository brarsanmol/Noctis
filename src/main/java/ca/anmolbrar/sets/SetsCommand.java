package ca.anmolbrar.sets;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("sets")
public class SetsCommand extends BaseCommand {

    public SetsCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public static void onSets(Player player) {
        Noctis.getInstance().getHera().getInventoryManager().getInventory("sets").show(player);
    }

    @Subcommand("list")
    public static void onList(Player player, User user) {
        player.sendMessage(new String[] {
                "",
                ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Sets",
                "",
        });
        for (SetType set : SetType.values()) {
            player.sendMessage(" " + ChatColor.LIGHT_PURPLE + set.getFriendlyName()
                    + CommandSymbols.SPACER + ""
                    + ChatColor.WHITE + (user.getSetsManager().getSets().contains(set) ? "Unlocked" : "Locked"));
        }
        player.sendMessage();
    }
}
