package game;

import enums.options.FoodType;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public class Food {
    private FoodType type;
    private int count;

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
