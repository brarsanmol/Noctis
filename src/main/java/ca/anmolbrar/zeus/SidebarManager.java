package ca.anmolbrar.zeus;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class SidebarManager {

    private final Set<Sidebar> sidebars;

    public SidebarManager() {
        this.sidebars = new HashSet<>();
    }

    public void addSidebar(Player player) {
        Preconditions.checkNotNull(player, "Player cannot be null");
        this.sidebars.add(new Sidebar(player));
    }

    public void removeSidebar(Player player) {
        this.sidebars.remove(this.getSidebar(player));
    }

    public Sidebar getSidebar(Player target) {
        Preconditions.checkNotNull(target, "Player cannot be null.");
        return this.sidebars.stream().filter(sidebar -> sidebar.getPlayer().equals(target)).findFirst().orElse(null);
    }

    public Set<Sidebar> getSidebars() {
        return sidebars;
    }
}