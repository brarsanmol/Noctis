package com.gmail.ceezuns.noctis.users.graves;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.users.User;
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
        user.getGravesManager().addGrave(new Grave(LocalDateTime.now().toString(),
                event.getEntity().getLastDamageCause().getCause().toString(),
                user.getPlayer().getLocation()));
    }

}
