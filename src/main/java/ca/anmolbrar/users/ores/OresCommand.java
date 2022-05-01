package ca.anmolbrar.users.ores;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("ores")
public class OresCommand extends BaseCommand {

    public OresCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public static void onOres(Player player, User user) {
        player.sendMessage(new String[] {
                "",
                ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Ores",
                "",
        });
        for (OreType ore : OreType.values()) {
            player.sendMessage(" " + CommandSymbols.SPACER + ChatColor.WHITE + ore.getFriendlyName() + " "
                    + ChatColor.DARK_GRAY + " - "
                    + ChatColor.GRAY + user.getOresManager().getAmountMined(ore));
        }
        player.sendMessage();
    }
}
