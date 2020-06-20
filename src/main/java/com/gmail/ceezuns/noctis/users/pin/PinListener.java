package com.gmail.ceezuns.noctis.users.pin;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PinListener implements Listener {

    public PinListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player && Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        if (Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityPickupItemEvent(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player && Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDropItemEvent(EntityDropItemEvent event) {
        if (event.getEntity() instanceof Player && Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser((Player) event.getEntity()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().getPin() == null || !Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getPinManager().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

}
