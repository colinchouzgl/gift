package game;

import commons.Rules;
import commons.Utils;
import enums.ActionType;
import enums.Time;
import enums.Tip;
import io.ConsoleUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Game {
    private int money;
    private int mood;
    private int love;
    private int experience;
    private int salary;
    private int date;
    private int time;
    private int apt; //action point

    public ConsoleUtils consoleUtils = new ConsoleUtils();

    public Game() {
        init();
    }

    public void init() {
        money = 200;
        mood = 100;
        love = 100;
        experience = 0;
        salary = Rules.getSalaryByExperience(experience);
        date = 1;
        time = Time.DAY.getValue();
        apt = 1;
    }

    public void run() {
        while (true) {
            doAction();
            timePass();
        }
    }

    public void doAction() {
        while (apt > 0) {
            consoleUtils.status(this);

            List<ActionType> options;
            if (!Utils.isWeekend(this) && !Utils.isNight(this)) {
                options = Arrays.asList(ActionType.WORK, ActionType.WORK_OVERTIME, ActionType.REST);
            } else {
                options = Arrays.asList(ActionType.EAT_SNACK, ActionType.CHAT, ActionType.WATCH_TV);
            }

            consoleUtils.actionOptions(options);
            int choice = consoleUtils.choose(options);
            switch (options.get(choice - 1)) {
                case WORK:
                    Actions.work(this);
                    break;
                case WORK_OVERTIME:
                    Actions.workOvertime(this);
                    break;
                case REST:
                    Actions.rest(this);
                    break;
                case EAT_SNACK:
                    Actions.eatSnack(this);
                    break;
                default:
            }
        }
    }

    public void timePass() {
        if (date >= 1 && date <= 4) {
            if (time == Time.DAY.getValue()) {
                time = Time.NIGHT.getValue();
                apt = 2;
                return;
            }
            time = Time.DAY.getValue();
            date++;
            apt = 1;
            return;
        }
        if (date == 5) {
            if (time == Time.DAY.getValue()) {
                time = Time.NIGHT.getValue();
                apt = 2;
                return;
            }
            date++;
            apt = 2;
            return;
        }
        if (date == 6) {
            date++;
            apt = 2;
            return;
        }
        date = 1;
        time = Time.DAY.getValue();
        apt = 1;
    }

    public void addMoney(int offset) {
        money += offset;
    }

    public void addMood(int offset) {
        mood += offset;
    }

    public void addLove(int offset) {
        love += offset;
    }

    public void addExperience(int offset) {
        experience += offset;
        updateSalary();
    }

    public void subApt(int offset) {
        apt -= offset;
    }

    private void updateSalary() {
        int newSalary = Rules.getSalaryByExperience(experience);
        if (newSalary > salary) {
            consoleUtils.tip(Tip.RAISE_SALARY, newSalary);
            salary = newSalary;
        }
    }


    public int getMoney() {
        return money;
    }

    public int getMood() {
        return mood;
    }

    public int getLove() {
        return love;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getApt() {
        return apt;
    }

    public ConsoleUtils getConsoleUtils() {
        return consoleUtils;
    }
}
