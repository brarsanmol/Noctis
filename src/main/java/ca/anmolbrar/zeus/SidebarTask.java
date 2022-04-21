package ca.anmolbrar.zeus;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitTask;

import java.util.stream.IntStream;

public class SidebarTask implements Runnable {

    private BukkitTask bukkitTask;

    public SidebarTask() {
        this.bukkitTask = Zeus.getInstance().getPlugin().getServer().getScheduler().runTaskTimerAsynchronously(Zeus.getInstance().getPlugin(), this, 20L, 20L);
    }

    @Override
    public void run() {
        Zeus.getInstance().getSidebarManager().getSidebars().forEach(sidebar -> {
            IntStream.range(0, Zeus.getInstance().getSidebarAdapter().getLines(sidebar.getPlayer()).size()).forEach(number -> {
                if (Zeus.getInstance().getSidebarAdapter().getLines(sidebar.getPlayer()).get(number).length() > 16) {
                    sidebar.getScoreboard().getTeam("zeus" + number).setPrefix(ChatColor.translateAlternateColorCodes('&', Zeus.getInstance().getSidebarAdapter().getLines(sidebar.getPlayer()).get(number).substring(0, 16)));
                    sidebar.getScoreboard().getTeam("zeus" + number).setSuffix(ChatColor.translateAlternateColorCodes('&', ChatColor.getLastColors(sidebar.getScoreboard().getTeam("zeus" + number).getPrefix()) + Zeus.getInstance().getSidebarAdapter().getLines(sidebar.getPlayer()).get(number).substring(16)));
                } else {
                    sidebar.getScoreboard().getTeam("zeus" + number).setPrefix(ChatColor.translateAlternateColorCodes('&', Zeus.getInstance().getSidebarAdapter().getLines(sidebar.getPlayer()).get(number)));
                }
                sidebar.getScoreboard().getObjective("zeus").getScore(Zeus.getInstance().getSidebarEntryGenerator().getNextEntry(number)).setScore(number);
            });
        });
    }

    public BukkitTask getBukkitTask() {
        return bukkitTask;
    }
}