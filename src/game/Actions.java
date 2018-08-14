package game;

import enums.ActionType;
import enums.Snack;
import enums.Tip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Actions {
    public static final int EXPERIENCE_INCR_WHILE_WORK = 5;
    public static final int MOOD_DROP_WHILE_WORK = 2;
    public static final int MOOD_INCR_WHILE_REST = 5;

    public static void work(Game game) {
        game.addMoney(game.getSalary());
        game.addExperience(EXPERIENCE_INCR_WHILE_WORK);
        game.addMood(-MOOD_DROP_WHILE_WORK);
        game.subApt(ActionType.WORK.getApt());
    }

    public static void workOvertime(Game game) {
        game.addMoney((int) (game.getSalary() * 1.5));
        game.addExperience((int) (EXPERIENCE_INCR_WHILE_WORK * 1.5));
        game.addMood((int) (MOOD_DROP_WHILE_WORK * 1.5));
        game.subApt(ActionType.WORK_OVERTIME.getApt());
    }

    public static void rest(Game game) {
        game.addMood(MOOD_INCR_WHILE_REST);
        game.subApt(ActionType.REST.getApt());
    }

    public static void eatSnack(Game game) {
        List<Snack> snacks = Arrays.asList(Snack.CANDY, Snack.CHOCOLATE, Snack.YOGURT);

        List<Snack> affordableSnacks = new ArrayList<>();
        List<Snack> unaffordableSnacks = new ArrayList<>();
        snacks.forEach(snack -> {
            if (snack.getPrice() > game.getMoney()) {
                unaffordableSnacks.add(snack);
            } else {
                affordableSnacks.add(snack);
            }
        });

        game.consoleUtils.snackOptions(affordableSnacks, unaffordableSnacks);

        if (affordableSnacks.size() == 0) {
            game.consoleUtils.tip(Tip.NO_SNACK_AFFORDABLE);
            return;
        }

        int choice = game.consoleUtils.choose(affordableSnacks);
        Snack snack = snacks.get(choice - 1);

        game.addMoney(-snack.getPrice());
        game.addMood(snack.getEffect());
        game.subApt(ActionType.EAT_SNACK.getApt());
    }
}
