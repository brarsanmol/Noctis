package ca.anmolbrar.listeners;

import ca.anmolbrar.Noctis;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class SpawnerListener implements Listener {

    private static final NamespacedKey KEY = new NamespacedKey(Noctis.getInstance(), "spawner-type");

    public SpawnerListener() {
        Noctis.getInstance().getServer().getPluginManager().registerEvents(this, Noctis.getInstance());
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.SPAWNER) {
            var state = (CreatureSpawner) event.getBlock().getState();
            var container = event.getItemInHand().getItemMeta().getPersistentDataContainer();

            state.setSpawnedType(EntityType.valueOf(container.getOrDefault(KEY, PersistentDataType.STRING, EntityType.PIG.name())));
            state.update();
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.SPAWNER)
            && event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            var state = (CreatureSpawner) event.getBlock().getState();

            var stack = new ItemStack(Material.SPAWNER);
            var meta = stack.getItemMeta();
            meta.getPersistentDataContainer().set(KEY, PersistentDataType.STRING, state.getSpawnedType().name());
            stack.setItemMeta(meta);

            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), stack);
        }
    }

}
