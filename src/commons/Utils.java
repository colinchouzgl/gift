package commons;

import enums.Time;
import game.Game;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Utils {
    public static boolean isWeekend(Game game) {
        return game.getDate() > 5;
    }

    public static boolean isNight(Game game) {
        return Time.NIGHT.getValue() == game.getTime();
    }

    public static String formatDateTime(Game game) {
        if (isWeekend(game)) {
            return game.getDate() == 6 ? "Saturday" : "Sunday";
        }
        String date;
        switch (game.getDate()) {
            case 1:
                date = "Monday";
                break;
            case 2:
                date = "Tuesday";
                break;
            case 3:
                date = "Wednesday";
                break;
            case 4:
                date = "Thursday";
                break;
            default:
                date = "Friday";
        }
        return date + " " + Time.get(game.getTime()).getDesc();
    }
}
