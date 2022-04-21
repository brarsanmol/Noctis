package ca.anmolbrar.hera;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HeraInventory {

    private static final ItemStack ITEMSTACK_AIR = new ItemBuilder(Material.AIR).build();

    private final String identifier;
    private final String displayName;
    private HeraInventoryRows rows;
    private final Inventory inventory;
    private final List<HeraItem> items;

    public HeraInventory(String identifier, String displayName, HeraInventoryRows rows) {
        this.identifier = identifier;
        this.displayName = displayName;
        this.rows = rows;
        this.inventory = Hera.getInstance().getPlugin().getServer().createInventory(null, rows.getSize(), displayName);
        this.items = new ArrayList<>();
        IntStream.range(0, rows.getSize()).forEach(index -> items.add(new HeraItem(index, this.inventory, ITEMSTACK_AIR)));
    }

    public HeraItem getSlot(int index) {
        return items.get(index);
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<HeraItem> getItems() {
        return items;
    }

    public void show(Player player) {
        player.openInventory(this.inventory);
    }

    public void hide(Player player) {
        player.closeInventory();
    }
}
