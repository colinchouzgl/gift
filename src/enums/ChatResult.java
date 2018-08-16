package enums;

/**
 * @author Zhou Guanliang
 * @since 2018/8/15
 */
public enum ChatResult {
    NORMAL(1, "一次很平常的聊天", 0),
    INTERESTING(2, "随便聊了一些白天的趣事", 0),
    BOOK(3, "聊了聊最近看的书", 0),

    HAPPY(101, "一次【愉悦】的聊天，甜蜜度+1", 1),
    CURSE(102, "和老公一起【骂公司的小婊子】，非常痛快，甜蜜度+1", 1),
    JOKE(103, "和老公讲了好多【笑话】，笑得肚子疼，甜蜜度+1", 1),
    MEMORY(104, "和老公【回忆从前】，傻笑了很久，甜蜜度+2", 2),
    FRIEND(105, "敞开心扉，两人默契如【知己】，甜蜜度+2", 2),
    CONFESSION(106, "聊着聊着，老公对你【深情表白】，你感动不已，甜蜜度+2", 2),

    COLD(201, "心情不好，全程【冷淡脸】，甜蜜度-1", -1),
    COMPLAIN(202, "聊着聊着【抱怨】这，【抱怨】那，甜蜜度-1", -1),
    UNFOCUSED(203, "两人互相【心不在焉】，干脆不聊了，甜蜜度-1", -1),
    ARGUE(204, "因为小事拌嘴，【说话很难听】，甜蜜度-2，", -2),
    FIGHT(205, "积怨已久，【大吵了一架】，甜蜜度-2，", -2),
    COLD_NIGHT(206, "吵了【隔夜架】，又气又难过，甜蜜度-2，", -2);

    ChatResult(int value, String desc, int effect) {
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

    public static ChatResult get(int value) {
        for (ChatResult result : ChatResult.values()) {
            if (value == result.getValue()) {
                return result;
            }
        }
        throw new IllegalArgumentException("参数异常" + value);
    }
}
