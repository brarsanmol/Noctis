package ca.anmolbrar;

import ca.anmolbrar.commands.CoordinatesCommand;
import ca.anmolbrar.hera.Hera;
import ca.anmolbrar.listeners.ChatListener;
import ca.anmolbrar.listeners.EndListener;
import ca.anmolbrar.listeners.RepairItemListener;
import ca.anmolbrar.listeners.SpawnerListener;
import ca.anmolbrar.mechanics.FireworkRecipe;
import ca.anmolbrar.protection.ProtectionCommand;
import ca.anmolbrar.protection.ProtectionListener;
import ca.anmolbrar.protection.ProtectionManager;
import ca.anmolbrar.sets.SetsCommand;
import ca.anmolbrar.sets.SetsHeraInventoryAdapterImpl;
import ca.anmolbrar.sets.SetsListener;
import ca.anmolbrar.users.User;
import ca.anmolbrar.users.UserListener;
import ca.anmolbrar.users.UserManager;
import ca.anmolbrar.users.cobble.CobbleCommand;
import ca.anmolbrar.users.cobble.CobbleListener;
import ca.anmolbrar.users.graves.GravesCommand;
import ca.anmolbrar.users.graves.GravesListener;
import ca.anmolbrar.users.markers.MarkersCommand;
import ca.anmolbrar.users.nicknames.NicknameCommand;
import ca.anmolbrar.users.ores.OresCommand;
import ca.anmolbrar.users.ores.OresListener;
import ca.anmolbrar.users.pin.PinCommand;
import ca.anmolbrar.users.pin.PinListener;
import ca.anmolbrar.utilities.CommandSymbols;
import ca.anmolbrar.utilities.ConfigurationFile;
import ca.anmolbrar.zeus.Zeus;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.InvalidCommandArgument;
import com.inkzz.spigot.armorevent.ArmorListener;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noctis extends JavaPlugin {

	private static Noctis instance;
	private BukkitCommandManager commandManager;
	private Zeus zeus;
	private Hera hera;
	private UserManager userManager;
	private ProtectionManager protectionManager;

	@Override
	public void onEnable() {
		instance = this;
		this.commandManager = new BukkitCommandManager(this);
		this.registerUserCommandContext();
		this.zeus = new Zeus(this, new SidebarAdapterImpl());
		this.hera = new Hera(this);
		this.hera.getInventoryManager().getInventories().add(new SetsHeraInventoryAdapterImpl().getInventory());
		this.userManager = new UserManager();
		this.protectionManager = new ProtectionManager(new ConfigurationFile("protection.yml"));
		this.protectionManager.load();
		new UserListener();
		new CobbleListener();
		new GravesListener();
		new PinListener();
		new OresListener();
		new ProtectionListener();
		new MarkersCommand();
		new CobbleCommand();
		new GravesCommand();
		new PinCommand();
		new OresCommand();
		new ProtectionCommand();
		new RepairItemListener();
		new EndListener();
		new ChatListener();
		new NicknameCommand();
		new FireworkRecipe();
		new ArmorListener();
		new SetsCommand();
		new SetsListener();
		new CoordinatesCommand();
		new SpawnerListener();
	}

	@Override
	public void onDisable() {
		this.protectionManager.save();
		this.userManager.clearUsers();
		this.userManager = null;
		instance = null;
	}

	public static Noctis getInstance() {
		return instance;
	}

	private void registerUserCommandContext() {
		this.getCommandManager().getCommandContexts().registerContext(User.class, context -> {
			CommandSender sender = context.getSender();

			if (sender instanceof Player) {
				return this.getUserManager().getUser(context.getPlayer());
			} else {
				throw new InvalidCommandArgument(CommandSymbols.DANGER + "" + ChatColor.GRAY + "You must be a player to perform this action.");
			}
		});
	}

	public BukkitCommandManager getCommandManager() {
		return commandManager;
	}

	public UserManager getUserManager() {
		return this.userManager;
	}

	public ProtectionManager getProtectionManager() {
		return this.protectionManager;
	}

	public Hera getHera() {
		return hera;
	}
}
