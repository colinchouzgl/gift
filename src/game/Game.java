package game;

import commons.Rules;
import enums.Time;
import enums.Tip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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

    private List<Food> foodList = new ArrayList<>();

    public Game() {
        init();
    }

    public void init() {
        money = 200;
        mood = 100;
        love = 100;
        experience = 0;
        salary = Rules.getSalaryByExperience(experience);
        date = 6;
        time = Time.DAY.getValue();
        apt = 1;
    }

//    public void run(IOUtils ioUtils) {
//        while (true) {
//            doAction(ioUtils);
//            timePass();
//        }
//    }

//    public void doAction(IOUtils ioUtils) {
//        while (apt > 0) {
//            ioUtils.status(this);
//
//            List<ActionType> options;
//            if (!Utils.isWeekend(this) && !Utils.isNight(this)) {
//                options = Arrays.asList(ActionType.WORK, ActionType.WORK_OVERTIME, ActionType.REST);
//            } else {
//                options = Arrays.asList(ActionType.EAT_SNACK, ActionType.CHAT, ActionType.WATCH_TV);
//            }
//
//            ioUtils.actionOptions(options);
//            int choice = ioUtils.choose(options);
//            switch (options.get(choice - 1)) {
//                case WORK:
//                    Actions.work(this);
//                    break;
//                case WORK_OVERTIME:
//                    Actions.workOvertime(this);
//                    break;
//                case REST:
//                    Actions.rest(this);
//                    break;
//                case EAT_SNACK:
//                    Actions.eatSnack(this, null);
//                    break;
//                default:
//            }
//        }
//    }

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
        money = money < 0 ? 0 : money;
    }

    public void addMood(int offset) {
        mood += offset;
        mood = mood < 0 ? 0 : mood;
    }

    public void addLove(int offset) {
        love += offset;
        love = love < 0 ? 0 : love;
    }

    public void addExperience(int offset) {
        experience += offset;
        experience = experience < 0 ? 0 : experience;
        updateSalary();
    }

    public void subApt(int offset) {
        apt -= offset;
        apt = apt < 0 ? 0 : apt;
    }

    private void updateSalary() {
        int newSalary = Rules.getSalaryByExperience(experience);
        if (newSalary > salary) {

            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, String.format(Tip.RAISE_SALARY.getDesc(), newSalary), "加薪啦", JOptionPane.INFORMATION_MESSAGE);

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

    public List<Food> getFoodList() {
        return foodList;
    }
}
