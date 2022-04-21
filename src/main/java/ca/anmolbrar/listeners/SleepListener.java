package ca.anmolbrar.listeners;

import ca.anmolbrar.Noctis;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepListener implements Listener {

    public SleepListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onBedEnterEvent(PlayerBedEnterEvent event) {
        Noctis.getInstance().getServer().broadcastMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GOLD + event.getPlayer().getName() + " is now sleeping!");
    }

    @EventHandler
    public void onBedEnterEvent(PlayerBedLeaveEvent event) {
        Noctis.getInstance().getServer().broadcastMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + " > " + ChatColor.GOLD + event.getPlayer().getName() + " is no longer sleep!");
    }
}
