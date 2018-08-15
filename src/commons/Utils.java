package commons;

import enums.Time;
import game.Game;

import java.util.Random;

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
            return game.getDate() == 6 ? "周六" : "周日";
        }
        String date;
        switch (game.getDate()) {
            case 1:
                date = "周一";
                break;
            case 2:
                date = "周二";
                break;
            case 3:
                date = "周三";
                break;
            case 4:
                date = "周四";
                break;
            default:
                date = "周五";
        }
        return date + " " + Time.get(game.getTime()).getDesc();
    }

    public int random(int min, int max) {
        Random random = new Random();
        //TODO
        return 0;
    }
}
