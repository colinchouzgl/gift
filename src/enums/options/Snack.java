package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public enum Snack {
    CANDY(1, "Candy", 5, 2),
    CHOCOLATE(2, "Chocolate", 10, 3),
    YOGURT(3, "Yogurt", 99999, 2),
    BREAD(4, "Bread", 5, 2),
    EGG(5, "Egg", 5, 2),
    MILK(6, "Milk", 5, 2),
    STORED(7, "Stored", 0, 0);

    Snack(int value, String desc, int price, int effect) {
        this.value = value;
        this.desc = desc;
        this.price = price;
        this.effect = effect;
    }

    private final int value;
    private final String desc;
    private final int price;
    private final int effect;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public int getEffect() {
        return effect;
    }

    public static Snack get(int value) {
        for (Snack snack : Snack.values()) {
            if (value == snack.getValue()) {
                return snack;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
