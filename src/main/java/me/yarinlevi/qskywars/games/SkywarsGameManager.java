package me.yarinlevi.qskywars.games;

import me.yarinlevi.minigameframework.MinigameFramework;
import me.yarinlevi.minigameframework.arena.Arena;
import me.yarinlevi.minigameframework.exceptions.ArenaNotExistException;
import me.yarinlevi.minigameframework.exceptions.NoArenaAvailable;
import me.yarinlevi.minigameframework.game.Game;
import me.yarinlevi.minigameframework.game.GameManager;

/**
 * @author YarinQuapi
 **/
public class SkywarsGameManager extends GameManager {
    @Override
    public Game createGame(Arena arena) throws NoArenaAvailable {
        if (arena.isAssigned()) {
            throw new NoArenaAvailable();
        } else {
            SkywarsGame game = new SkywarsGame(arena);
            arena.setAssigned(true);
            this.getAvailableGames().add(game);
            return game;
        }
    }

    @Override
    public Game createGame(String arenaGame) throws ArenaNotExistException, NoArenaAvailable {
        Arena arena = MinigameFramework.getFramework().getArenaManager().getArena(arenaGame);
        if (!arena.isAssigned()) {
            Game game = new SkywarsGame(arena);
            arena.setAssigned(true);
            this.getAvailableGames().add(game);
            return game;
        } else {
            throw new NoArenaAvailable();
        }
    }
}
