package ca.anmolbrar.users.graves;

import ca.anmolbrar.Noctis;
import ca.anmolbrar.users.User;
import ca.anmolbrar.utilities.CommandSymbols;
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

        user.getPlayer().sendMessage(CommandSymbols.DANGER + "" + ChatColor.WHITE + grave.getTimestamp()
                + ChatColor.GRAY + "("
                + ChatColor.LIGHT_PURPLE + grave.getLocation().getX() + ChatColor.GRAY + ", "
                + ChatColor.LIGHT_PURPLE + grave.getLocation().getY() + ChatColor.GRAY + ", "
                + ChatColor.LIGHT_PURPLE + grave.getLocation().getZ() + ChatColor.GRAY + ")");

    }

}
