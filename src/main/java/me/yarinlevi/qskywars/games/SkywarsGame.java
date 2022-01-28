package me.yarinlevi.qskywars.games;

import me.yarinlevi.minigameframework.api.FastPlayerAccess;
import me.yarinlevi.minigameframework.arena.Arena;
import me.yarinlevi.minigameframework.game.Game;
import me.yarinlevi.minigameframework.utilities.MiniaturizedLocation;
import me.yarinlevi.minigameframework.worldedit.WorldEditUtils;
import me.yarinlevi.qskywars.QSkyWars;
import org.bukkit.Location;

import java.io.File;

/**
 * @author YarinQuapi
 **/
public class SkywarsGame extends Game {
    protected SkywarsGame(Arena arena) {
        super(arena);
    }

    @Override
    public void construct() {
        this.getPlayers().forEach(player -> {
            int index = this.getPlayers().indexOf(player);

            MiniaturizedLocation location = this.getArena().getLocations().get(index);

            location.teleport(player);
        });

    }

    @Override
    public void start() {
        this.startStartProcess();

        for (MiniaturizedLocation location : this.getArena().getLocations()) {
            Location loc = location.toLocation();

            WorldEditUtils.paste(loc.getWorld(), WorldEditUtils.load(new File(QSkyWars.getInstance().getDataFolder() + "/cages/", "empty.schem")), loc.toVector());
        }
    }
}
