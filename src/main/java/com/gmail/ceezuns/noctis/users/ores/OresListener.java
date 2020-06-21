package com.gmail.ceezuns.noctis.users.ores;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OresListener implements Listener {

    public OresListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (OreType.valueOf(event.getBlock().getType().name()) != null) {
            event.getPlayer().sendMessage(event.getBlock().getType().name());
            Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getOresManager().incrementOreMined(OreType.valueOf(event.getBlock().getType().name()));
        }
    }


}
