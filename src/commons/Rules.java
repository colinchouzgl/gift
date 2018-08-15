package commons;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Rules {
    public static int getSalaryByExperience(int experience) {
        if (experience < 50) {
            return 100;
        }
        if (experience < 100) {
            return 200;
        }
        if (experience < 200) {
            return 300;
        }
        if (experience < 300) {
            return 400;
        }
        if (experience < 500) {
            return 500;
        }
        if (experience < 800) {
            return 600;
        }
        if (experience < 1200) {
            return 800;
        }
        if (experience < 2000) {
            return 1000;
        }
        return 1500;
    }

    public static int computChatResult(int mood){
        //TODO
        return 1;
    }
}
