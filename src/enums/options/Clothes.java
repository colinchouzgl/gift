package enums.options;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum Clothes {
    SKIRT(1, "Skirt", 40, 3),
    DRESS(2, "Dress", 60, 5),
    T_SHIRT(3, "T-Shirt", 30, 2),
    SHIRT(4, "Shirt", 30, 2),
    SWEATER(5, "Sweater", 50, 4),
    PAINTS(6, "Paints", 50, 4),
    COAT(7, "Coat", 70, 6),
    HAT(8, "Hat", 20, 1),
    SHOES(9, "Shoes", 60, 5);

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
