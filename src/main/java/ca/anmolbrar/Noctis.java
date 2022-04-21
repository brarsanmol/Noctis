package ca.anmolbrar;

import ca.anmolbrar.commands.CoordsCommand;
import ca.anmolbrar.listeners.ChatListener;
import ca.anmolbrar.listeners.EndListener;
import ca.anmolbrar.listeners.RepairItemListener;
import ca.anmolbrar.mechanics.FireworkRecipe;
import ca.anmolbrar.protection.ProtectionCommand;
import ca.anmolbrar.protection.ProtectionListener;
import ca.anmolbrar.protection.ProtectionManager;
import ca.anmolbrar.sets.SetsHeraInventoryAdapterImpl;
import ca.anmolbrar.sets.SetsCommand;
import ca.anmolbrar.sets.SetsListener;
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
import ca.anmolbrar.utilities.ConfigurationFile;
import com.inkzz.spigot.armorevent.ArmorListener;
import ca.anmolbrar.hera.Hera;
import ca.anmolbrar.zeus.Zeus;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noctis extends JavaPlugin {

	private static Noctis instance;
	private Zeus zeus;
	private Hera hera;
	private UserManager userManager;
	private ProtectionManager protectionManager;

	@Override
	public void onEnable() {
		instance = this;
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
		new CoordsCommand();
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
