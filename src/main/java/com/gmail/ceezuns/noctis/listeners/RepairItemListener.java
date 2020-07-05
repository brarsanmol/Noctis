package com.gmail.ceezuns.noctis.listeners;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class RepairItemListener implements Listener {

    public RepairItemListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onPrepareAnvilEvent(PrepareAnvilEvent event) {
        if (event.getInventory().getRepairCost() >= event.getInventory().getMaximumRepairCost()) {
            Noctis.getInstance().getServer().getScheduler().runTask(Noctis.getInstance(), () -> event.getInventory().setRepairCost(event.getInventory().getMaximumRepairCost() - 1));
        }
    }

}
