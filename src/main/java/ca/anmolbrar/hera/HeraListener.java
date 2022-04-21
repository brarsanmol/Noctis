package ca.anmolbrar.hera;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.server.PluginDisableEvent;

public class HeraListener implements Listener {

    public HeraListener() {
        Hera.getInstance().getPlugin().getServer().getPluginManager().registerEvents(this, Hera.getInstance().getPlugin());
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            HeraInventory inventory = Hera.getInstance().getInventoryManager().getInventory(event.getView().getTitle());
            if (inventory != null) {
                event.setCancelled(true);
                if (inventory.getSlot(event.getSlot()) != null && inventory.getSlot(event.getSlot()).getHeraItemAction() != null) {
                    inventory.getSlot(event.getSlot()).getHeraItemAction().execute(event);
                }
            }
        }
    }

    @EventHandler
    public void onPluginDisableEvent(PluginDisableEvent event) {
        Hera.getInstance().getInventoryManager().getInventories().stream().forEach(inventory -> inventory.getItems().clear());
        Hera.getInstance().getInventoryManager().getInventories().clear();
    }

}
