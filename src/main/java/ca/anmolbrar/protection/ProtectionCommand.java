package ca.anmolbrar.protection;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandAlias("protection|pvp")
@CommandPermission("noctis.commands.protection")
public class ProtectionCommand extends BaseCommand {

    public ProtectionCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @HelpCommand
    public static void onHelp(CommandSender sender) {
        sender.sendMessage(new String[] {
                "",
                ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Protection Help",
                "",
                ChatColor.GRAY + " <> = Required Argument",
                ChatColor.GRAY + " [] = Optional Argument",
                "",
                CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/protection enable" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Turn on protection",
                CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/protection disable" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Turn off protection",
                ""
        });
    }

    @Subcommand("enable|on")
    public static void onEnable(CommandSender sender) {
        Noctis.getInstance().getProtectionManager().setProtectionEnabled(true);
        sender.getServer().broadcastMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "Protection is now enabled, you will be immune from entity damage and hunger level changes.");
    }

    @Subcommand("disable|off")
    public static void onDisable(CommandSender sender) {
        Noctis.getInstance().getProtectionManager().setProtectionEnabled(false);
        sender.getServer().broadcastMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "Protection is now disabled, you will no longer be immune from entity damage and hunger level changes.");
    }
}
