package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Spot {
    SUBURB(1, "Suburb", 40, 5, 3),
    HAPPY_VALLEY(2, "Happy Valley", 60, 8, 4),
    GALLERY(3, "Gallery", 30, 3, 2),
    NLGX(4, "NanLuo GuXiang", 30, 3, 2),
    HOUHAI(5, "HOU HAI", 35, 3, 3),
    TRAVEL(6, "Travel", 0, 0, 0);

    Spot(int value, String desc, int price, int moodEffect, int loveEffect) {
        this.value = value;
        this.desc = desc;
        this.price = price;
        this.moodEffect = moodEffect;
        this.loveEffect = loveEffect;
    }

    private final int value;
    private final String desc;
    private final int price;
    private final int moodEffect;
    private final int loveEffect;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public int getMoodEffect() {
        return moodEffect;
    }

    public int getLoveEffect() {
        return loveEffect;
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