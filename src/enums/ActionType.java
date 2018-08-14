package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public enum ActionType {
    WORK(1, "Work", 1),
    WORK_OVERTIME(2, "Work Overtime", 1),
    REST(3, "Rest", 1),

    EAT_SNACK(51, "Eat Snack", 1),
    CHAT(52, "Chat", 1),
    WATCH_TV(53, "Watch TV", 1);

    ActionType(int value, String desc, int apt) {
        this.value = value;
        this.desc = desc;
        this.apt = apt;
    }

    private final int value;
    private final String desc;
    private final int apt;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public int getApt() {
        return apt;
    }

    public static ActionType get(int value) {
        for (ActionType type : ActionType.values()) {
            if (value == type.getValue()) {
                return type;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
