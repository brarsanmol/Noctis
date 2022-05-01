package ca.anmolbrar.listeners;

import ca.anmolbrar.Noctis;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    public ChatListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        event.setFormat(ChatColor.LIGHT_PURPLE + event.getPlayer().getDisplayName() + ChatColor.WHITE + ": " + event.getMessage());
    }

}
