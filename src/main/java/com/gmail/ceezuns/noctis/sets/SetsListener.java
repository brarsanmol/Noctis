package com.gmail.ceezuns.noctis.sets;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
import com.gmail.ceezuns.noctis.utilities.SetsUtilities;
import com.inkzz.spigot.armorevent.PlayerArmorEquipEvent;
import com.inkzz.spigot.armorevent.PlayerArmorUnequipEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

public class SetsListener implements Listener {

    public SetsListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onPlayerArmorEquipEvent(PlayerArmorEquipEvent event) {
        User user = Noctis.getInstance().getUserManager().getUser(event.getPlayer());

        if (user.getSetsManager().getSets().isEmpty()) {
            return;
        } else {
            if (user.getSetsManager().getActivatedSet() == null) {
                user.getSetsManager().getSets().forEach(set -> {
                    if (SetsUtilities.isWearingFullSet(event.getPlayer(), set)) {
                        for (PotionEffect effect : set.getEffects()) {
                            event.getPlayer().addPotionEffect(effect);
                        }
                        event.getPlayer().sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You have now equipped the " + ChatColor.GOLD + set.getFriendlyName() + ChatColor.GRAY + " set");
                        user.getSetsManager().setActivatedSet(set);
                        return;
                    }
                });
            }
        }
    }

    @EventHandler
    public void onPlayerArmorUnequipEvent(PlayerArmorUnequipEvent event) {
        User user = Noctis.getInstance().getUserManager().getUser(event.getPlayer());

        if (user.getSetsManager().getSets().isEmpty() || user.getSetsManager().getActivatedSet() == null) {
            return;
        } else {
            for (PotionEffect effect : user.getSetsManager().getActivatedSet().getEffects()) {
                event.getPlayer().removePotionEffect(effect.getType());
            }
            event.getPlayer().sendMessage(ChatColor.GOLD + "Server " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "You have now unequipped the " + ChatColor.GOLD + user.getSetsManager().getActivatedSet().getFriendlyName() + ChatColor.GRAY + " set");
            user.getSetsManager().setActivatedSet(null);
        }
    }

}
