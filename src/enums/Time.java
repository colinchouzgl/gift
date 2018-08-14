package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public enum Time {
    DAY(1, "Day"),
    NIGHT(2, "Night");

    Time(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private final int value;
    private final String desc;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static Time get(int value) {
        for (Time time : Time.values()) {
            if (value == time.getValue()) {
                return time;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
