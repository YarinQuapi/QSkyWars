package me.yarinlevi.qskywars.chest.loottables;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.yarinlevi.minigameframework.utilities.FileUtils;
import me.yarinlevi.qskywars.QSkyWars;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YarinQuapi
 **/
public class LootTableData {
    private final Map<Integer, LootTable> lootTableTiers = new HashMap<>();

    private final Gson gson;
    private final File file;
    private final FileConfiguration data;

    public LootTableData(QSkyWars instance) {
        file = new File(instance.getDataFolder(), "tiers.yml");
        data = YamlConfiguration.loadConfiguration(file);
        gson = new GsonBuilder().setPrettyPrinting().create();

        FileUtils.registerData(file, data);
    }

    public void loadLootTables() {
        data.getKeys(false).forEach(x -> {
            int tier = data.getInt(x + ".tier");

            List<String> jsons = data.getStringList(x + ".items");
            LootTable lootTable = new LootTable();

            for (String json : jsons) {
                String itemString = json.split("%")[0];

                lootTable.getLootTableItems().put(gson.fromJson(itemString, LootTableItem.class), Integer.valueOf(json.split("%")[1]));
            }

            lootTableTiers.put(tier, lootTable);
        });

        if (lootTableTiers.isEmpty()) {
            if (data.getKeys(false).isEmpty()) {
                QSkyWars.getInstance().getLogger().info("Creating sample loot table..");

                LootTable lootTable = new LootTable();
                lootTable.getLootTableItems().put(new LootTableItem(new ItemStack(Material.STONE_SHOVEL), 1, 10), 100);
                lootTable.getLootTableItems().put(new LootTableItem(new ItemStack(Material.SANDSTONE), 32, 128), 100);

                lootTableTiers.put(1, lootTable);

                this.saveLootTables();

                QSkyWars.getInstance().getLogger().info("Successfully created sample loot table! please review tiers.yml in your config files");
            }
        }
    }

    public void saveLootTables() {
        lootTableTiers.forEach((x, y) -> {
            data.set("tier" + x + ".tier", x);

            List<String> jsons = new ArrayList<>();

            y.getLootTableItems().forEach((j, i) -> {
                jsons.add(gson.toJson(j) + "%" + i);
            });

            data.set("tier" + x + ".items", jsons);

        });

        FileUtils.saveData(file, data);
    }
}
