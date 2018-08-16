package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum TravelSpot {
    QHDAO(1, "Qin Huang Dao", 800, 20, 10),
    BDHE(2, "Bei Dai He", 500, 15, 8),
    TIANJIN(3, "Tianjin", 400, 10, 5);

    TravelSpot(int value, String desc, int price, int moodEffect, int loveEffect) {
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

    public static TravelSpot get(int value) {
        for (TravelSpot spot : TravelSpot.values()) {
            if (value == spot.getValue()) {
                return spot;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}