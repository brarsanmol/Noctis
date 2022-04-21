package ca.anmolbrar.hera;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class HeraItem {

    private int index;
    private Inventory inventory;
    private ItemStack item;
    private HeraItemAction heraItemAction;

    public HeraItem(int index, Inventory inventory, ItemStack item) {
        this.index = index;
        this.inventory = inventory;
        this.item = item;
        this.inventory.setItem(this.index, this.item);
    }

    public ItemStack getItem() {
        return item;
    }

    public HeraItem setItem(ItemStack item) {
        this.item = item;
        this.inventory.setItem(this.index, this.item);
        return this;
    }

    public HeraItemAction getHeraItemAction() {
        return heraItemAction;
    }

    public HeraItem setHeraItemAction(HeraItemAction heraItemAction) {
        this.heraItemAction = heraItemAction;
        return this;
    }
}
