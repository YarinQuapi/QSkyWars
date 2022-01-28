package me.yarinlevi.qskywars.utilities;

import me.yarinlevi.minigameframework.game.Game;
import org.bukkit.entity.Player;

/**
 * @author YarinQuapi
 **/
public class DeathMessage {
    public static void broadcast(Game game, Player player) {
        game.getGamePlayers().keySet().forEach(x -> x.sendMessage(player.getDisplayName() + " died! what a noob! haha"));
    }
}
