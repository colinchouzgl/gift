package io;

import enums.ActionType;
import enums.Snack;
import enums.Tip;
import game.Game;

import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public interface IOUtils {
    void status(Game game);

    void tip(Tip tip, Object... params);

    int choose(List options);

    void actionOptions(List<ActionType> options);

    void snackOptions(List<Snack> affordableSnacks, List<Snack> unaffordableSnacks);
}
