package com.gmail.ceezuns.noctis.sets;

import com.gmail.ceezuns.noctis.Noctis;
import me.ceezuns.hera.HeraInventory;
import me.ceezuns.hera.HeraInventoryAdapter;
import me.ceezuns.hera.HeraInventoryRows;
import me.ceezuns.hera.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SetsHeraInventoryAdapterImpl implements HeraInventoryAdapter  {

    @Override
    public HeraInventory getInventory() {
        HeraInventory inventory = new HeraInventory("sets", "Sets", HeraInventoryRows.THREE);

        IntStream.range(0, 27).forEach(index ->
                inventory.getSlot(index).setItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "PLACEHOLDER!").build())
        );

        inventory.getSlot(11)
                .setItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                        .setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "WARRIOR")
                        .setLore(Arrays.asList(ChatColor.GRAY + "Unlock the " + ChatColor.GOLD + "Warrior" + ChatColor.GRAY + " set!",
                                ChatColor.GRAY + "→ " + ChatColor.AQUA + SetType.WARRIOR.getCost() + " DIAMONDS",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Absorption",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Speed I")).build())
                .setHeraItemAction(action -> {
                    Noctis.getInstance().getServer().dispatchCommand(action.getWhoClicked(), "sets unlock warrior");
                    Noctis.getInstance().getHera().getInventoryManager().getInventory("sets").hide((Player) action.getWhoClicked());
                });

        inventory.getSlot(13)
                .setItem(new ItemBuilder(Material.IRON_CHESTPLATE)
                        .setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "MINER")
                        .setLore(Arrays.asList(ChatColor.GRAY + "Unlock the " + ChatColor.GOLD + "MINER" + ChatColor.GRAY + " set!",
                                ChatColor.GRAY + "→ " + ChatColor.AQUA + SetType.MINER.getCost() + " DIAMONDS",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Speed I",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Haste II",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Fire Resistance II",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Night Vision II")).build())
                .setHeraItemAction(action -> {
                    Noctis.getInstance().getServer().dispatchCommand(action.getWhoClicked(), "sets unlock miner");
                    Noctis.getInstance().getHera().getInventoryManager().getInventory("sets").hide((Player) action.getWhoClicked());
                });

        inventory.getSlot(15)
                .setItem(new ItemBuilder(Material.LEATHER_CHESTPLATE)
                        .setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "EXPLORER")
                        .setLore(Arrays.asList(ChatColor.GRAY + "Unlock the " + ChatColor.GOLD + "EXPLORER" + ChatColor.GRAY + " set!",
                                ChatColor.GRAY + "→ " + ChatColor.AQUA + SetType.EXPLORER.getCost() + " DIAMONDS",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Speed III",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Dolphins Grace",
                                ChatColor.GRAY + "→ " + ChatColor.GOLD + "Slow Falling II")).build())
                .setHeraItemAction(action -> {
                    Noctis.getInstance().getServer().dispatchCommand(action.getWhoClicked(), "sets unlock explorer");
                    Noctis.getInstance().getHera().getInventoryManager().getInventory("sets").hide((Player) action.getWhoClicked());
                });

        return inventory;
    }
}
