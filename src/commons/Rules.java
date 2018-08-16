package commons;

import enums.ChatResult;
import enums.RandomEvent;
import enums.TVResult;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Rules {
    public static final int EVENT_PROBABILITY = 30;

    public static int getSalaryByExperience(int experience) {
        if (experience < 50) {
            return 100;
        }
        if (experience < 100) {
            return 120;
        }
        if (experience < 200) {
            return 150;
        }
        if (experience < 500) {
            return 200;
        }
        if (experience < 1000) {
            return 300;
        }
        if (experience < 2000) {
            return 400;
        }
        if (experience < 3000) {
            return 500;
        }
        if (experience < 5000) {
            return 600;
        }
        return 800;
    }

    public static ChatResult computeChatResult(int mood) {
        if (mood > 300) {
            return ChatResult.get(Utils.random(ChatResult.MEMORY.getValue(), ChatResult.CONFESSION.getValue()));
        }
        if (mood > 200) {
            return ChatResult.get(Utils.random(ChatResult.HAPPY.getValue(), ChatResult.JOKE.getValue()));
        }
        if (mood > 80) {
            return ChatResult.get(Utils.random(ChatResult.NORMAL.getValue(), ChatResult.BOOK.getValue()));
        }
        if (mood > 50) {
            return ChatResult.get(Utils.random(ChatResult.COLD.getValue(), ChatResult.UNFOCUSED.getValue()));
        }
        return ChatResult.get(Utils.random(ChatResult.ARGUE.getValue(), ChatResult.COLD_NIGHT.getValue()));
    }

    public static TVResult computeTVResult(int mood) {
        if (mood > 300) {
            return TVResult.get(Utils.random(TVResult.ROMANTIC.getValue(), TVResult.KID.getValue()));
        }
        if (mood > 200) {
            return TVResult.get(Utils.random(TVResult.COMEDY.getValue(), TVResult.OLD.getValue()));
        }
        if (mood > 80) {
            return TVResult.get(Utils.random(TVResult.PEACE.getValue(), TVResult.CAT.getValue()));
        }
        if (mood > 50) {
            return TVResult.get(Utils.random(TVResult.BORING.getValue(), TVResult.ARGUE.getValue()));
        }
        return TVResult.get(Utils.random(TVResult.FIGHT.getValue(), TVResult.FIGHT_AGAIN.getValue()));
    }

    public static RandomEvent computeEveningEvent(int love) {
        boolean happen = EVENT_PROBABILITY > Utils.random(1, 100);
        if (happen) {
            if (love > 250) {
                return RandomEvent.get(Utils.random(RandomEvent.POEM.getValue(), RandomEvent.MASSAGE.getValue()));
            }
            if (love > 150) {
                return RandomEvent.get(Utils.random(RandomEvent.TOFU.getValue(), RandomEvent.KISS.getValue()));
            }
            if (love > 80) {
                return RandomEvent.get(Utils.random(RandomEvent.BAD_CAT.getValue(), RandomEvent.LATE.getValue()));
            }
            if (love > 50) {
                return RandomEvent.get(Utils.random(RandomEvent.ALONE.getValue(), RandomEvent.ANGRY_DRIVER.getValue()));
            }
            return RandomEvent.get(Utils.random(RandomEvent.THROW.getValue(), RandomEvent.COLD_WAR.getValue()));
        }
        return RandomEvent.NONE;
    }
}
