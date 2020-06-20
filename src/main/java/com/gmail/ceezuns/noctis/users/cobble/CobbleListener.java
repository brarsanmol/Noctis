package com.gmail.ceezuns.noctis.users.cobble;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class CobbleListener implements Listener {

	private static Noctis instance = Noctis.getInstance();

	public CobbleListener() {
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onEntityPickupItemEvent(EntityPickupItemEvent event) {
		if (event.getEntity() instanceof Player) {
			User user = instance.getUserManager().getUser((Player) event.getEntity());

			if (user.getCobbleManager().getCobbleStatus() == CobbleStatus.DO_NOT_PICKUP) {
				if (event.getItem().getItemStack().getType() == Material.COBBLESTONE) {
					event.getItem().getItemStack().setAmount(0);
					event.setCancelled(true);
				}
			}
		}
	}
}
