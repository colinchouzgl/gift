package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Spot {
    SUBURB(1, "Suburb", 5, 2),
    HAPPY_VALLEY(2, "Happy Valley", 10, 3),
    GALLERY(3, "Gallery", 99999, 2),
    NLGX(4, "NanLuo GuXiang", 5, 2),
    HOUHAI(5, "HOU HAI", 5, 2),
    TRAVEL(6, "Travel", 5, 2);

    Spot(int value, String desc, int price, int effect) {
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

    public static Spot get(int value) {
        for (Spot spot : Spot.values()) {
            if (value == spot.getValue()) {
                return spot;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}