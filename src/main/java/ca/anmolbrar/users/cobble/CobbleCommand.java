package ca.anmolbrar.users.cobble;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CobbleCommand extends BaseCommand {

	private static Noctis instance = Noctis.getInstance();

	public CobbleCommand() {
		Noctis.getInstance().getCommandManager().registerCommand(this);
	}

	@Default
	public static void onCobble(Player player) {
		User user = instance.getUserManager().getUser(player);

		if (user.getCobbleManager().getCobbleStatus() == CobbleStatus.PICKUP) {
			user.getCobbleManager().setCobbleStatus(CobbleStatus.DO_NOT_PICKUP);
			player.sendMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + "You are now unable to pickup cobblestone");
		} else {
			user.getCobbleManager().setCobbleStatus(CobbleStatus.PICKUP);
			player.sendMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + ChatColor.GRAY + "You are now able pickup cobblestone");
		}
	}
}
