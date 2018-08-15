package game;

import enums.ActionType;
import enums.Snack;
import io.GameUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Actions {
    public static final int EXPERIENCE_INCR_WHILE_WORK = 5;
    public static final int MOOD_DROP_WHILE_WORK = 2;
    public static final int MOOD_INCR_WHILE_REST = 5;

    public static void work(GameUI ui) {
        ui.game.addMoney(ui.game.getSalary());
        ui.game.addExperience(EXPERIENCE_INCR_WHILE_WORK, null);
        ui.game.addMood(-MOOD_DROP_WHILE_WORK);
        ui.game.subApt(ActionType.WORK.getApt());
    }

    public static void workOvertime(GameUI ui) {
        ui.game.addMoney((int) (ui.game.getSalary() * 1.5));
        ui.game.addExperience((int) (EXPERIENCE_INCR_WHILE_WORK * 1.5), null);
        ui.game.addMood((int) (MOOD_DROP_WHILE_WORK * 1.5));
        ui.game.subApt(ActionType.WORK_OVERTIME.getApt());
    }

    public static void rest(GameUI ui) {
        ui.game.addMood(MOOD_INCR_WHILE_REST);
        ui.game.subApt(ActionType.REST.getApt());
    }

    public static void eatSnack(GameUI ui) {
        ui.itemTitle.setText("可购买的零食：");
        ui.itemTitle.setVisible(true);
        List<Snack> snacks = Arrays.asList(Snack.values());

        List<Snack> affordableSnacks = new ArrayList<>();
        List<Snack> unaffordableSnacks = new ArrayList<>();
        snacks.forEach(snack -> {
            if (snack.getPrice() > ui.game.getMoney()) {
                unaffordableSnacks.add(snack);
            } else {
                affordableSnacks.add(snack);
            }
        });

        int column = 1, currentX = 90, currentY = 70;
        for (Snack snack : snacks) {
            JButton button = new JButton();
            int x = currentX;
            int y = currentY;

            column++;
            if (column > 4) {
                column = 1;
                currentX = 90;
                currentY += 50;
            } else {
                currentX += 160;
            }

            button.setBounds(x, y, 150, 40);
            button.setText(snack.getDesc());
            button.setToolTipText("价格：" + snack.getPrice() + "，效果：" + snack.getEffect());
            button.setFont(new Font("黑体", Font.PLAIN, 18));
            button.addActionListener(ui);

            if (snack.getPrice() > ui.game.getMoney()) {
                button.setEnabled(false);
            }
            ui.itemPane.add(button);
            ui.snackGroup.add(button);
            ui.itemPane.repaint();
        }
//
//        ioUtils.snackOptions(affordableSnacks, unaffordableSnacks);
//
//        if (affordableSnacks.size() == 0) {
//            ioUtils.tip(Tip.NO_SNACK_AFFORDABLE);
//            return;
//        }
//
//        int choice = ioUtils.choose(affordableSnacks);
//        Snack snack = snacks.get(choice - 1);
//
//        ui.game.addMoney(-snack.getPrice());
//        ui.game.addMood(snack.getEffect());
//        ui.game.subApt(ActionType.EAT_SNACK.getApt());
    }
}
