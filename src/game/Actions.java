package game;

import commons.Rules;
import commons.Utils;
import enums.ActionType;
import enums.ChatResult;
import enums.RandomEvent;
import enums.Snack;
import io.GameUI;

import javax.swing.*;
import java.awt.*;
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
        ui.updateStatus();
    }

    public static void workOvertime(GameUI ui) {
        ui.game.addMoney((int) (ui.game.getSalary() * 1.5));
        ui.game.addExperience((int) (EXPERIENCE_INCR_WHILE_WORK * 1.5), null);
        ui.game.addMood(-(int) (MOOD_DROP_WHILE_WORK * 1.5));
        ui.game.subApt(ActionType.WORK_OVERTIME.getApt());
        ui.updateStatus();
    }

    public static void rest(GameUI ui) {
        ui.game.addMood(MOOD_INCR_WHILE_REST);
        ui.game.subApt(ActionType.REST.getApt());
        ui.updateStatus();
    }

    public static void showSnack(GameUI ui) {
        ui.itemTitle.setText("可购买的零食：");
        ui.itemTitle.setVisible(true);
        List<Snack> snacks = Arrays.asList(Snack.values());

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
            button.setName("snack" + snack.getValue());
            button.addActionListener(ui);

            if (snack.getPrice() > ui.game.getMoney()) {
                button.setEnabled(false);
            }
            ui.itemPane.add(button);
            ui.snackGroup.add(button);
            ui.itemPane.repaint();
        }
    }

    public static void eatSnack(GameUI ui, JButton button) {
        Snack snack = Snack.get(Integer.parseInt(button.getName().replaceAll("snack", "")));
        ui.game.addMoney(-snack.getPrice());
        ui.game.addMood(snack.getEffect());
        ui.game.subApt(ActionType.EAT_SNACK.getApt());
        ui.updateStatus();
    }

    public static void chat(GameUI ui) {
        ChatResult result = Rules.computeChatResult(ui.game.getMood());

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, result.getDesc(), "聊了一会", JOptionPane.INFORMATION_MESSAGE);

        ui.game.addLove(result.getEffect());
        ui.game.subApt(ActionType.CHAT.getApt());
        ui.updateStatus();
    }

    public static void watchTV(GameUI ui) {

    }

    public static void randomEvent(GameUI ui) {
        if (!Utils.isWeekend(ui.game) && Utils.isNight(ui.game)) {
            RandomEvent event = Rules.computeEveningEvent(ui.game.getLove());
            if(!event.equals(RandomEvent.NONE)){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, event.getDesc(), "偶然事件", JOptionPane.INFORMATION_MESSAGE);
                ui.game.addLove(event.getEffect());
            }
        }
    }
}
