package ca.anmolbrar.protection;

import ca.anmolbrar.Noctis;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class ProtectionListener implements Listener {

    public ProtectionListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && Noctis.getInstance().getProtectionManager().isProtectionEnabled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        // Do we need to really check if the entity is a player?
        // Follow up on this. ^^^^
        if (event.getEntity() instanceof Player && Noctis.getInstance().getProtectionManager().isProtectionEnabled()) {
            event.setCancelled(true);
        }
    }

}
