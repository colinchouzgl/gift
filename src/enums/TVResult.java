package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum TVResult {
    PEACE(1, "两个人静静地看了几集电视", 0),

    HAPPY(101, "xx，甜蜜度+1", 1),
    CURSE(102, "xx，甜蜜度+1", 1),
    MEMORY(103, "xx，甜蜜度+", 2),
    FRIEND(104, "xx，甜蜜度+2", 2),

    COLD(201, "xx，甜蜜度-1", -1),
    COMPLAIN(202, "xx，甜蜜度-1", -1),
    ARGUE(203, "xx，甜蜜度-2，", -2),
    FIGHT(204, "xx，甜蜜度-2，", -2);

    TVResult(int value, String desc, int effect) {
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

    public static TVResult get(int value) {
        for (TVResult result : TVResult.values()) {
            if (value == result.getValue()) {
                return result;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
