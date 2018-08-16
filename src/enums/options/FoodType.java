package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum FoodType {
    NOODLES(1, "泡面", 5, 1),
    BREAD(2, "面包", 5, 1),
    PIE(3, "好丽友", 8, 2),
    ICE(4, "冰糕", 8, 2),
    CAKE(5, "蛋糕", 12, 3),
    MILK(6, "牛奶", 8, 2);

    FoodType(int value, String desc, int price, int effect) {
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

    public static FoodType get(int value) {
        for (FoodType type : FoodType.values()) {
            if (value == type.getValue()) {
                return type;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
