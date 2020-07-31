package com.gmail.ceezuns.noctis;

import me.ceezuns.zeus.SidebarAdapter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SidebarAdapterImpl implements SidebarAdapter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Override
    public String getTitle() {
        return ChatColor.translateAlternateColorCodes('&', "&d&lThe Ravens SMP");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add(ChatColor.translateAlternateColorCodes('&', "&7" + DATE_FORMATTER.format(LocalDateTime.now())));
        lines.add(" ");
        lines.add(ChatColor.translateAlternateColorCodes('&', "&dOnline"));
        lines.add(Noctis.getInstance().getServer().getOnlinePlayers().size() + " / " + Noctis.getInstance().getInstance().getServer().getMaxPlayers());
        lines.add(" ");
        lines.add(ChatColor.translateAlternateColorCodes('&', "&dActive Set"));
        lines.add(Noctis.getInstance().getUserManager().getUser(player).getSetsManager().getActivatedSet() == null ? "None" : Noctis.getInstance().getUserManager().getUser(player).getSetsManager().getActivatedSet().getFriendlyName());
        lines.add(" ");
        lines.add(ChatColor.translateAlternateColorCodes('&', "&7https://discord.gg/SQv5ZWs"));

        Collections.reverse(lines);
        return lines;
    }
}
