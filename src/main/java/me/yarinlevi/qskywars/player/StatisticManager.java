package me.yarinlevi.qskywars.player;

import me.yarinlevi.minigameframework.player.Statistics;
import org.bukkit.entity.Player;

/**
 * @author YarinQuapi
 **/
public class StatisticManager implements Statistics {
    @Override
    public void addKill(Player player) {

    }

    @Override
    public int getKills(Player player) {
        return 0;
    }

    @Override
    public void addDeath(Player player) {

    }

    @Override
    public int getDeaths(Player player) {
        return 0;
    }

    @Override
    public void setMultiplier(Player player, float v) {

    }

    @Override
    public float getMultiplier(Player player) {
        return 1f;
    }

    @Override
    public void addWin(Player player) {

    }

    @Override
    public int getWins(Player player) {
        return 0;
    }

    @Override
    public void addGamePlayed(Player player) {

    }

    @Override
    public int getGamesPlayed(Player player) {
        return 0;
    }
}
