package me.ceezuns.hera;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface HeraItemAction {

    void execute(InventoryClickEvent event);

}
