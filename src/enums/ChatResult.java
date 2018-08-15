package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/15
 */
public enum ChatResult {
    PEACE(1, "一次很平常的聊天", 0),

    HAPPY(101, "一次愉悦的聊天，甜蜜度+1", 1),
    CURSE(102, "一起骂公司的小婊子，非常痛快，甜蜜度+1", 1),
    MEMORY(103, "一起回忆从前，傻笑了很久，甜蜜度+", 2),
    FRIEND(104, "敞开心扉，默契如知己，甜蜜度+2", 2),

    COLD(201, "心情不好，全程冷淡脸，甜蜜度-1", -1),
    COMPLAIN(202, "突然开始抱怨，心里烧起无名火，甜蜜度-1", -1),
    ARGUE(203, "因为小事拌嘴，说话很难听，甜蜜度-2，", -2),
    FIGHT(204, "积怨已久，大吵了一架，甜蜜度-2，", -2);

    ChatResult(int value, String desc, int effect) {
        this.value = value;
        this.desc = desc;
        this.effect = effect;
    }

    private final int value;
    private final String desc;
    private final int effect;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public int getEffect() {
        return effect;
    }

    public static ChatResult get(int value) {
        for (ChatResult result : ChatResult.values()) {
            if (value == result.getValue()) {
                return result;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
