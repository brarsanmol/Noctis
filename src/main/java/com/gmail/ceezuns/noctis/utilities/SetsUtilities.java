package com.gmail.ceezuns.noctis.utilities;

import com.gmail.ceezuns.noctis.sets.SetType;
import org.bukkit.entity.Player;

public class SetsUtilities {

    //TODO: Find a better way to implement this, but for now this traditional way works just fine.
    public static boolean isWearingFullSet(Player player, SetType set) {
        return  (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getType().equals(set.getArmor()[0])) &&
                (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType().equals(set.getArmor()[1])) &&
                (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getType().equals(set.getArmor()[2])) &&
                (player.getInventory().getBoots() != null && player.getInventory().getBoots().getType().equals(set.getArmor()[3]));
    }

}
