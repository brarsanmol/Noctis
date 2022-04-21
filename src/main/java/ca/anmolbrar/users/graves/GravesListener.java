package ca.anmolbrar.users.graves;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.time.LocalDateTime;

public class GravesListener implements Listener {

    public GravesListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        User user = Noctis.getInstance().getUserManager().getUser(event.getEntity());

        Grave grave = new Grave(LocalDateTime.now().withNano(0).toString(),
                event.getEntity().getLastDamageCause().getCause().toString(),
                user.getPlayer().getLocation());
        user.getGravesManager().addGrave(grave);

        user.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Graves " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");
        user.getPlayer().sendMessage(ChatColor.GOLD + "Timestamp" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getTimestamp());
        user.getPlayer().sendMessage(ChatColor.GOLD + "Death Cause" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getDeathCause());
        user.getPlayer().sendMessage(ChatColor.GOLD + "Location" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + grave.getLocation().getWorld().getName() + ", " + grave.getLocation().getX() + ", " + grave.getLocation().getY() + ", " + grave.getLocation().getZ());
        user.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------" + ChatColor.GOLD + " Graves " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------");

    }

}
