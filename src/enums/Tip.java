package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public enum Tip {
    RAISE_SALARY(1, "Your salary is raised to %d!"),
    NO_SNACK_AFFORDABLE(1, "There's no snack affordable!");

    Tip(int value, String desc) {
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

    public static Tip get(int value) {
        for (Tip tip : Tip.values()) {
            if (value == tip.getValue()) {
                return tip;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
