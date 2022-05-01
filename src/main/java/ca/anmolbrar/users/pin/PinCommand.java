package ca.anmolbrar.users.pin;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("pin")
public class PinCommand extends BaseCommand {

    public PinCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @HelpCommand
    public static void onHelp(CommandSender sender) {
        sender.sendMessage(new String[] {
                "",
                ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "Pin Help",
                "",
                ChatColor.GRAY + " <> = Required Argument",
                ChatColor.GRAY + " [] = Optional Argument",
                "",
                CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/pin authenticate <pin>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Authenticate with your pin",
                CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/pin create <pin>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Create your pin",
                CommandSymbols.SPACER + "" + ChatColor.LIGHT_PURPLE + "/pin update <pin>" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Update your pin",
                ""
        });
    }

    @Subcommand("authenticate")
    public static void onAuthenticate(Player player, User user, String pin) {
        if (user.getPinManager().isAuthenticated()) {
            player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "You are already authenticated.");
        } else if (user.getPinManager().getPin().equals(pin)) {
            user.getPinManager().setAuthenticated(true);
            player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "You have been authenticated.");
        } else {
            player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "The pin you provided, is invalid, please try again.");
        }
    }

    @Subcommand("create")
    public static void onCreate(Player player, User user, String pin) {
        if (user.getPinManager().isAuthenticated()) {
            player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "You are already authenticated.");
        } else if (user.getPinManager().getPin() == null) {
            user.getPinManager().setPin(pin);
            user.getPinManager().setAuthenticated(true);
            player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "Your pin has been created.");
        } else {
            player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "You already have a pin, to update your pin use the command /pin update <string>.");
        }
    }

    @Subcommand("update")
    public static void onUpdate(Player player, User user, String pin) {
        if (!user.getPinManager().isAuthenticated()) {
            player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + "You must be authenticated to update your pin.");
        } else {
            user.getPinManager().setPin(pin);
            player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "Your pin has been updated.");
        }
    }
}
