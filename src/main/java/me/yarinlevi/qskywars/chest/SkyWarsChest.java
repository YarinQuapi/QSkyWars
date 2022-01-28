package me.yarinlevi.qskywars.chest;

import com.sk89q.worldedit.world.item.ItemType;
import lombok.Getter;
import me.yarinlevi.qskywars.chest.loottables.LootTable;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author YarinQuapi
 **/
public class SkyWarsChest {
    @Getter private final int tier;
    @Getter private final LootTable lootTable;
    @Getter private final Location location;

    public SkyWarsChest(int tier, LootTable lootTable, Location location) {
        this.tier = tier;
        this.lootTable = lootTable;
        this.location = location;
    }

    public void populate() {
        Block block = this.location.getBlock();
        BlockState blockState = block.getState();

        if (!(blockState instanceof Chest)) {
            // Block is not a chest
            return;
        }

        Chest chest = (Chest) blockState;
        Inventory inv = chest.getSnapshotInventory();



        // Send chest update
        chest.update();
    }
}
