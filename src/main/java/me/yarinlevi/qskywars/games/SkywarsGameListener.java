package me.yarinlevi.qskywars.games;

import me.yarinlevi.minigameframework.game.Game;
import me.yarinlevi.minigameframework.game.events.QPlayerDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author YarinQuapi
 **/
public class SkywarsGameListener implements Listener {
    @EventHandler
    public void onPlayerKill(QPlayerDeathEvent event) {
        Game game = event.getGame();
        Player victim = event.getVictim();

        game.lose(victim);
        game.getGamePlayers().get(victim.getKiller()).addKill();

        if (game.getAlivePlayers().size() == 1) {
            game.win(game.getAlivePlayers().stream().findFirst().orElseThrow());
        }
    }
}
