package ca.anmolbrar.users.nicknames;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("nickname|nick")
public class NicknameCommand extends BaseCommand {

    public NicknameCommand() {
        Noctis.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public static void onNickname(Player player, User user, String name) {
        user.getNicknameManager().setNickname(name);
        user.getPlayer().setDisplayName(name);
        player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "Your nickname has now been changed to " + name + ".");
    }
}