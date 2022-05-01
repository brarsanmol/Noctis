package ca.anmolbrar.users.graves;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("graves|g")
public class GravesCommand extends BaseCommand {

    public GravesCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public static void onGraves(Player player, User user) {
        var graves = user.getGravesManager().getGraves();

        if (graves.isEmpty()) {
            player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "You currently have no graves.");
        } else {
            player.sendMessage(new String[] {
                    "",
                    ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Graves",
                    "",
            });
            graves.forEach(grave -> player.sendMessage(" " + ChatColor.WHITE + grave.getTimestamp()
                    + ChatColor.GRAY + "("
                    + ChatColor.LIGHT_PURPLE + grave.getLocation().getX() + ChatColor.GRAY + ", "
                    + ChatColor.LIGHT_PURPLE + grave.getLocation().getY() + ChatColor.GRAY + ", "
                    + ChatColor.LIGHT_PURPLE + grave.getLocation().getZ() + ChatColor.GRAY + ")"));
            player.sendMessage();
        }
    }

}
