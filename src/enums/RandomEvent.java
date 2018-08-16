package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/15
 */
public enum RandomEvent {
    NONE(0, "什么也没有发生", 0),

    //Evening event
    BAD_CAT(1, "小宝和Java搞乱了厨房", 0),
    LATE(2, "老公加班晚回来了一会", 0),

    TOFU(101, "老公下班路上给你带了一份【臭豆腐】，甜蜜度+1", 1),
    CHICKEN(102, "老公下班路上给你带了一份【大鸡排】，甜蜜度+1", 1),
    KISS(103, "老公下班到家心血来潮给了你一个【热吻】，甜蜜度+1", 1),
    POEM(104, "老公白天抽空给你写了一首【情诗】，回家念给你听，甜蜜度+2", 2),
    FLOWER(105, "老公下班路上看到卖花的，买了一束【玫瑰】送给你，甜蜜度+2", 2),
    MASSAGE(106, "老公殷勤地给你做了全套【马杀鸡】，甜蜜度+2", 2),

    ALONE(201, "老公今天【没有接你下班】，自己回家了，甜蜜度-1", -1),
    SILENCE(202, "老公下班后一路都很【沉默】，好像心情不好，甜蜜度-1", -1),
    ANGRY_DRIVER(203, "老公对着路上的车【发脾气】，顺便拿你撒气，甜蜜度-1", -1),
    THROW(204, "老公下班路上跟你吵了一架，把你的【小龙虾摔了】，甜蜜度-2", -2),
    ROAR(205, "老公回家路上莫名地当街【吼了你一顿】，甜蜜度-2", -2),
    COLD_WAR(206, "因为一件小事，你和老公【冷战】了一整天，甜蜜度-2", -2);

    RandomEvent(int value, String desc, int effect) {
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

    public static RandomEvent get(int value) {
        for (RandomEvent result : RandomEvent.values()) {
            if (value == result.getValue()) {
                return result;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
