package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Goods {
    LIPSTICK(1, "口红", 100, 20),
    FOUNDATION(2, "粉底液", 200, 40),
    EYEBROW_PENCIL(3, "眉笔", 30, 6),
    EYE_SHADOW(4, "眼影", 150, 30),
    SKIN_CARE(5, "护肤品", 150, 30),
    BAG(6, "包包", 350, 50),
    CLOTHES(7, "【衣服】", 0, 0),
    FOODS(8, "【食品】", 0, 0);

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
