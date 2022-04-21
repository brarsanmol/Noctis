package ca.anmolbrar.hera;

import java.util.ArrayList;
import java.util.List;

public class HeraInventoryManager {

    private final List<HeraInventory> inventories;

    public HeraInventoryManager() {
        this.inventories = new ArrayList<>();
    }

    public HeraInventory getInventory(String identifier) {
        return this.inventories.stream().filter(inventory -> inventory.getIdentifier().equalsIgnoreCase(identifier)).findFirst().orElse(null);
    }

    public List<HeraInventory> getInventories() {
        return inventories;
    }
}
