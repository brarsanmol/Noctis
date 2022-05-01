package ca.anmolbrar.commands;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("coordinates|coords|c")
public class CoordinatesCommand extends BaseCommand {

    public CoordinatesCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public static void onCoordinates(Player player) {
        player.getServer().broadcastMessage(CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + player.getName()
                + " Coordinates " + ChatColor.GRAY + "("
                + ChatColor.WHITE + player.getLocation().getBlockX() + ChatColor.GRAY + ", "
                + ChatColor.WHITE + player.getLocation().getBlockY() + ChatColor.GRAY + ", "
                + ChatColor.WHITE + player.getLocation().getBlockZ() + ChatColor.GRAY + ")");
    }
}
