package commons;

import enums.ChatResult;
import enums.RandomEvent;

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
            return 200;
        }
        if (experience < 200) {
            return 300;
        }
        if (experience < 300) {
            return 400;
        }
        if (experience < 500) {
            return 500;
        }
        if (experience < 800) {
            return 600;
        }
        if (experience < 1200) {
            return 800;
        }
        if (experience < 2000) {
            return 1000;
        }
        return 1500;
    }

    public static ChatResult computeChatResult(int mood) {
        if (mood > 180) {
            return ChatResult.get(Utils.random(ChatResult.MEMORY.getValue(), ChatResult.FRIEND.getValue()));
        }
        if (mood > 120) {
            return ChatResult.get(Utils.random(ChatResult.HAPPY.getValue(), ChatResult.CURSE.getValue()));
        }
        if (mood > 80) {
            return ChatResult.get(Utils.random(ChatResult.PEACE.getValue(), ChatResult.PEACE.getValue()));
        }
        if (mood > 50) {
            return ChatResult.get(Utils.random(ChatResult.COLD.getValue(), ChatResult.COMPLAIN.getValue()));
        }
        return ChatResult.get(Utils.random(ChatResult.ARGUE.getValue(), ChatResult.FIGHT.getValue()));
    }

    public static RandomEvent computeEveningEvent(int love) {
        boolean happen = EVENT_PROBABILITY > Utils.random(1, 100);
        if (happen) {
            if (love > 180) {
                return RandomEvent.get(Utils.random(RandomEvent.POEM.getValue(), RandomEvent.FLOWER.getValue()));
            }
            if (love > 120) {
                return RandomEvent.get(Utils.random(RandomEvent.TOFU.getValue(), RandomEvent.CHICKEN.getValue()));
            }
            if (love > 80) {
                return RandomEvent.get(Utils.random(RandomEvent.NNN.getValue(), RandomEvent.NNN.getValue()));
            }
            if (love > 50) {
                return RandomEvent.get(Utils.random(RandomEvent.ALONE.getValue(), RandomEvent.SILENCE.getValue()));
            }
            return RandomEvent.get(Utils.random(RandomEvent.THROW.getValue(), RandomEvent.ROAR.getValue()));
        }
        return RandomEvent.NONE;
    }
}
