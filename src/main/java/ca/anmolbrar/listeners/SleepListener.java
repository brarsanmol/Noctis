package ca.anmolbrar.listeners;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.utilities.CommandSymbols;
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
        event.getPlayer().getServer().broadcastMessage(CommandSymbols.SUCCESS + "" + ChatColor.GRAY + event.getPlayer().getName() + " is now sleeping!");
    }

    @EventHandler
    public void onBedLeaveEvent(PlayerBedLeaveEvent event) {
        event.getPlayer().getServer().broadcastMessage(CommandSymbols.DANGER + "" + ChatColor.GRAY + event.getPlayer().getName() + " is no longer sleeping!");    }
}
