package ca.anmolbrar.zeus;

import com.google.common.base.Preconditions;
import org.bukkit.plugin.java.JavaPlugin;

public class Zeus {

    private static Zeus instance;
    private final JavaPlugin plugin;
    private final SidebarAdapter sidebarAdapter;
    private final SidebarManager sidebarManager;
    private final SidebarEntryGenerator sidebarEntryGenerator;
    private final SidebarTask sidebarTask;

    public Zeus(JavaPlugin plugin, SidebarAdapter sidebarAdapter) {
        Preconditions.checkNotNull(plugin, "JavaPlugin cannot be null.");
        Preconditions.checkNotNull(sidebarAdapter, "SidebarViewProvider cannot be null.");
        instance = this;
        this.plugin = plugin;
        this.sidebarAdapter = sidebarAdapter;
        this.sidebarManager = new SidebarManager();
        this.sidebarEntryGenerator = new SidebarEntryGenerator();
        this.sidebarTask = new SidebarTask();
        new SidebarListener();
    }

    protected static Zeus getInstance() {
        return instance;
    }

    protected JavaPlugin getPlugin() {
        return plugin;
    }

    protected SidebarAdapter getSidebarAdapter() {
        return sidebarAdapter;
    }

    protected SidebarManager getSidebarManager() {
        return sidebarManager;
    }

    protected SidebarEntryGenerator getSidebarEntryGenerator() {
        return sidebarEntryGenerator;
    }

    protected SidebarTask getSidebarTask() {
        return sidebarTask;
    }
}
