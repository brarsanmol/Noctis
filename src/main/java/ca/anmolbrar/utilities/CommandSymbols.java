package ca.anmolbrar.utilities;

import org.bukkit.ChatColor;

public enum CommandSymbols {

    SUCCESS(ChatColor.GRAY + "" + ChatColor.BOLD + '(' + ChatColor.GREEN + "" + ChatColor.BOLD + '!' + ChatColor.GRAY + "" + ChatColor.BOLD + ") "),
    DANGER(ChatColor.GRAY + "" + ChatColor.BOLD + '(' + ChatColor.DARK_RED + "" + ChatColor.BOLD + '!' + ChatColor.GRAY + "" + ChatColor.BOLD + ") "),
    SPACER(ChatColor.GRAY + " \u00BB ");

    private String symbol;

    CommandSymbols(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
