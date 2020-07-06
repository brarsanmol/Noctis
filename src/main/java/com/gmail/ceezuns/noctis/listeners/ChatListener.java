package com.gmail.ceezuns.noctis.listeners;

import com.gmail.ceezuns.noctis.Noctis;
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
        event.setFormat(ChatColor.GOLD + event.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY + event.getMessage());
    }

}
