package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum TravelSpot {
    QHDAO(1, "Qin Huang Dao", 5, 2),
    BDHE(2, "Bei Dai He", 10, 3),
    TIANJIN(3, "Tianjin", 99999, 2);

    TravelSpot(int value, String desc, int price, int effect) {
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

    public static TravelSpot get(int value) {
        for (TravelSpot spot : TravelSpot.values()) {
            if (value == spot.getValue()) {
                return spot;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}