package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/16
 */
public enum TVResult {
    PEACE(1, "两个人静静地看了几集电视剧", 0),
    CAT(1, "一边看着电视，一边撸猫", 0),
    SHOW(1, "找了找新出的综艺，比较有意思", 0),

    COMEDY(101, "看了几集喜剧节目，两人【笑个不停】，甜蜜度+1", 1),
    SAN_GUO(102, "看到【三国剧】，老公给你讲了很多知识，甜蜜度+1", 1),
    OLD(103, "一起看了一部【老片】，互相讲起小时候的事情，甜蜜度+1", 1),
    ROMANTIC(104, "看了一部【爱情片】，看着看着就和老公亲了起来，甜蜜度+2", 2),
    NINE_LIVES(105, "一起看了一遍【九条命】，回忆起了刚认识的时候，甜蜜度+2", 2),
    KID(106, "看了一部【亲子片】，突然就想要个孩子了，甜蜜度+2", 2),

    BORING(201, "老公非要看外国战争片，你完全【不感兴趣】，甜蜜度-1", -1),
    SILENCE(202, "找不到合适的节目，两个人【沉默】地换着频道，甜蜜度-1", -1),
    ARGUE(202, "看着看着电视，两个人开始【拌嘴】，甜蜜度-1", -1),
    FIGHT(203, "两个人因为看什么节目【吵了一架】，话题升级很严重，甜蜜度-2，", -2),
    IGNORE(204, "老公不是玩手机就是玩电脑，根本【不理你】，你很委屈，甜蜜度-2，", -2),
    FIGHT_AGAIN(204, "看到电视里的情节想起了之前吵的架，【又吵了一次】，甜蜜度-2，", -2);

    TVResult(int value, String desc, int effect) {
        this.value = value;
        this.desc = desc;
        this.effect = effect;
    }

    private final int value;
    private final String desc;
    private final int effect;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public int getEffect() {
        return effect;
    }

    public static TVResult get(int value) {
        for (TVResult result : TVResult.values()) {
            if (value == result.getValue()) {
                return result;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
