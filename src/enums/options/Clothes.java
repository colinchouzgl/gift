package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Clothes {
    SKIRT(1, "短裙", 80, 18),
    DRESS(2, "连衣裙", 120, 25),
    T_SHIRT(3, "T恤", 60, 15),
    SHIRT(4, "衬衫", 80, 18),
    SWEATER(5, "毛衣", 100, 22),
    PAINTS(6, "裤子", 100, 22),
    COAT(7, "风衣", 180, 28),
    HAT(8, "帽子", 50, 15),
    SHOES(9, "鞋", 120, 25);

    Clothes(int value, String desc, int price, int effect) {
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

    public static Clothes get(int value) {
        for (Clothes clothes : Clothes.values()) {
            if (value == clothes.getValue()) {
                return clothes;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
