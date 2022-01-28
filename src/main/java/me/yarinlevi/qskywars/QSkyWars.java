package me.yarinlevi.qskywars;

import lombok.Getter;
import me.yarinlevi.minigameframework.MinigameFramework;
import me.yarinlevi.qskywars.chest.loottables.LootTableData;
import me.yarinlevi.qskywars.games.SkywarsGameListener;
import me.yarinlevi.qskywars.games.SkywarsGameManager;
import me.yarinlevi.qskywars.player.StatisticManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class QSkyWars extends JavaPlugin {
    @Getter private static QSkyWars instance;
    @Getter private static MinigameFramework framework;
    @Getter private LootTableData lootTableData;

    @Override
    public void onEnable() {
        instance = this;

        File cages = new File(QSkyWars.getInstance().getDataFolder() + "/cages/");
        if (!cages.exists())
            cages.mkdirs();

        framework = new MinigameFramework();
        framework.initialize(this);

        // Chest LootTable loading
        lootTableData = new LootTableData(this);
        lootTableData.loadLootTables();

        framework.setGameManager(new SkywarsGameManager());
        getServer().getPluginManager().registerEvents(new SkywarsGameListener(), this);


        framework.setStatistics(new StatisticManager());
    }
}
