package ca.anmolbrar.hera;

import com.google.common.base.Preconditions;
import org.bukkit.plugin.java.JavaPlugin;

public class Hera {

    private static Hera instance;
    private final JavaPlugin plugin;
    private final HeraInventoryManager inventoryManager;

    public Hera(JavaPlugin plugin) {
        Preconditions.checkNotNull(plugin, "JavaPlugin cannot be null.");
        instance = this;
        this.plugin = plugin;
        this.inventoryManager = new HeraInventoryManager();
        new HeraListener();
    }

    public static Hera getInstance() {
        return instance;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public HeraInventoryManager getInventoryManager() {
        return inventoryManager;
    }
}
