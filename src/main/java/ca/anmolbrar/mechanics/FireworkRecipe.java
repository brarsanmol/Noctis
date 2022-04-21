package ca.anmolbrar.mechanics;

import ca.anmolbrar.Noctis;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class FireworkRecipe {

    private static final ShapedRecipe FIREWORK_RECIPE = new ShapedRecipe(new NamespacedKey(Noctis.getInstance(), "firework_rocket"), new ItemStack(Material.FIREWORK_ROCKET, 1));

    public FireworkRecipe() {
        FIREWORK_RECIPE.shape("PPP", " C ", "PPP");
        FIREWORK_RECIPE.setIngredient('P', Material.PAPER);
        FIREWORK_RECIPE.setIngredient('C', Material.CHORUS_FRUIT);
        Noctis.getInstance().getServer().addRecipe(FIREWORK_RECIPE);
    }

}
