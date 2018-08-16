package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public enum Snack {
    CHOCOLATE(1, "巧克力", 12, 3),
    LA_TIAO(2, "辣条", 8, 2),
    DUCK_NECK(3, "鸭脖", 15, 4),
    YOGURT(4, "酸奶", 5, 1),
    DRINK(5, "饮料", 5, 1),
    PLUM(6, "话梅", 5, 1),
    ICE_CREAM(7, "冰淇淋", 12, 3),
    CHEESE_CAKE(8, "芝士蛋糕", 20, 5),
    STORED(9, "【储藏的】", 0, 0);

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
