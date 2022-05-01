package ca.anmolbrar.users.ores;

import ca.anmolbrar.Noctis;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OresListener implements Listener {

    public OresListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        // We catch the exception, because the valueOf method throws an exception when a enum does not have that value, and there no is no way to go around it without creating a separate map.
        try {
            if (OreType.valueOf(event.getBlock().getType().name()) != null) {
                Noctis.getInstance().getUserManager().getUser(event.getPlayer()).getOresManager().incrementOreMined(OreType.valueOf(event.getBlock().getType().name()));
            }
        } catch (IllegalArgumentException exception) {
            // Do nothing, as we don't want to throw the exception.
            exception.printStackTrace();
            return;
        }
    }


}
