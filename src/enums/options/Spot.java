package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Spot {
    SUBURB(1, "郊区", 100, 20, 2),
    HAPPY_VALLEY(2, "欢乐谷", 180, 32, 5),
    GALLERY(3, "美术馆", 80, 18, 1),
    NLGX(4, "南锣鼓巷", 120, 22, 3),
    HOUHAI(5, "后海", 150, 25, 4),
    TRAVEL(6, "【旅游】", 0, 0, 0);

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