package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Goods {
    LIPSTICK(1, "Lipstick", 5, 2),
    SKIN_CARE(2, "Skin Care", 10, 3),
    BAG(3, "Bag", 99999, 2),
    CLOTHS(4, "Cloths", 5, 2),
    FOODS(5, "Foods", 5, 2);

    Goods(int value, String desc, int price, int effect) {
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

    public static Goods get(int value) {
        for (Goods goods : Goods.values()) {
            if (value == goods.getValue()) {
                return goods;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
