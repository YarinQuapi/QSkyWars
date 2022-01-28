package me.yarinlevi.qskywars.chest.loottables;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author YarinQuapi
 **/
public class LootTableItem {
    private Material material;
    private int minAmount;
    private int maxAmount;


    public LootTableItem(Material itemStack, int minAmount, int maxAmount) {
        this.material = itemStack;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
}
