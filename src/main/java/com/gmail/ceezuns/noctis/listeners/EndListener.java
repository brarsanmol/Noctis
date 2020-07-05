package com.gmail.ceezuns.noctis.listeners;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EndListener implements Listener {

    public EndListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onEnderDragonDeathEvent(EntityDeathEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            event.getEntity().getLocation().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(Material.ELYTRA, 1));
            event.getEntity().getLocation().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(Material.SHULKER_SHELL, 2));
        }
    }

}
