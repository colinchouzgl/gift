package game;

import commons.Rules;
import commons.Utils;
import enums.ActionType;
import enums.ChatResult;
import enums.RandomEvent;
import enums.TVResult;
import enums.options.Goods;
import enums.options.Snack;
import enums.options.Spot;
import enums.options.TravelSpot;
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
    public static final int MOVIE_PRICE = 20;
    public static final int MOOD_INCR_WHILE_WATCHING_MOVIE = 5;

    public static void work(GameUI ui) {
        ui.game.addMoney(ui.game.getSalary());
        ui.game.addExperience(EXPERIENCE_INCR_WHILE_WORK);
        ui.game.addMood(-MOOD_DROP_WHILE_WORK);
        ui.game.subApt(ActionType.WORK.getApt());
        ui.updateStatus();
    }

    public static void workOvertime(GameUI ui) {
        ui.game.addMoney((int) (ui.game.getSalary() * 1.5));
        ui.game.addExperience((int) (EXPERIENCE_INCR_WHILE_WORK * 1.5));
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
        TVResult result = Rules.computeTVResult(ui.game.getMood());

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, result.getDesc(), "看了一会电视", JOptionPane.INFORMATION_MESSAGE);

        ui.game.addLove(result.getEffect());
        ui.game.subApt(ActionType.WATCH_TV.getApt());
        ui.updateStatus();
    }

    public static void showGoods(GameUI ui) {
        ui.itemTitle.setText("可购买的商品：");
        ui.itemTitle.setVisible(true);
        List<Goods> goodsList = Arrays.asList(Goods.values());

        int column = 1, currentX = 90, currentY = 70;
        for (Goods goods : goodsList) {
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
            button.setText(goods.getDesc());
            button.setToolTipText("价格：" + goods.getPrice() + "，效果：" + goods.getEffect());
            button.setFont(new Font("黑体", Font.PLAIN, 18));
            button.setName("goods" + goods.getValue());
            button.addActionListener(ui);

            if (goods.getPrice() > ui.game.getMoney()) {
                button.setEnabled(false);
            }
            ui.itemPane.add(button);
            ui.goodsGroup.add(button);
            ui.itemPane.repaint();
        }
    }

    public static void shopping(GameUI ui, JButton button) {
        Goods goods = Goods.get(Integer.parseInt(button.getName().replaceAll("goods", "")));
        ui.game.addMoney(-goods.getPrice());
        ui.game.addMood(goods.getEffect());
        ui.game.subApt(ActionType.SHOPPING.getApt());
        ui.updateStatus();
    }

    public static void showSpot(GameUI ui) {
        ui.itemTitle.setText("要去玩的地点：");
        ui.itemTitle.setVisible(true);
        List<Spot> spots = Arrays.asList(Spot.values());

        int column = 1, currentX = 90, currentY = 70;
        for (Spot spot : spots) {
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
            button.setText(spot.getDesc());
            button.setToolTipText("价格：" + spot.getPrice() + "，效果：" + spot.getEffect());
            button.setFont(new Font("黑体", Font.PLAIN, 18));
            button.setName("spot" + spot.getValue());
            button.addActionListener(ui);

            if (spot.getPrice() > ui.game.getMoney()) {
                button.setEnabled(false);
            }
            ui.itemPane.add(button);
            ui.spotGroup.add(button);
            ui.itemPane.repaint();
        }
    }

    public static void hangAround(GameUI ui, JButton button) {
        Spot spot = Spot.get(Integer.parseInt(button.getName().replaceAll("spot", "")));
        ui.game.addMoney(-spot.getPrice());
        ui.game.addMood(spot.getEffect());
        ui.game.subApt(ActionType.HANG_AROUND.getApt());
        ui.updateStatus();
    }

    public static void showTravelSpot(GameUI ui) {
        ui.itemTitle.setText("外出旅游的地点：");
        ui.itemTitle.setVisible(true);
        List<TravelSpot> travelSpots = Arrays.asList(TravelSpot.values());

        int column = 1, currentX = 90, currentY = 70;
        for (TravelSpot travelSpot : travelSpots) {
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
            button.setText(travelSpot.getDesc());
            button.setToolTipText("价格：" + travelSpot.getPrice() + "，效果：" + travelSpot.getEffect());
            button.setFont(new Font("黑体", Font.PLAIN, 18));
            button.setName("travelSpot" + travelSpot.getValue());
            button.addActionListener(ui);

            if (travelSpot.getPrice() > ui.game.getMoney()) {
                button.setEnabled(false);
            }
            ui.itemPane.add(button);
            ui.travelSpotGroup.add(button);
            ui.itemPane.repaint();
        }
    }

    public static void travel(GameUI ui, JButton button) {
        TravelSpot travelSpot = TravelSpot.get(Integer.parseInt(button.getName().replaceAll("travelSpot", "")));
        ui.game.addMoney(-travelSpot.getPrice());
        ui.game.addMood(travelSpot.getEffect());
        ui.game.subApt(ActionType.TRAVEL.getApt());
        ui.updateStatus();
    }

    public static void watchMovie(GameUI ui) {
        if (ui.game.getMoney() < MOVIE_PRICE) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "你的现金不够了", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ui.game.addMoney(-MOVIE_PRICE);
        ui.game.addMood(MOOD_INCR_WHILE_WATCHING_MOVIE);
        ui.game.subApt(ActionType.REST.getApt());
        ui.updateStatus();
    }

    public static void extraWork(GameUI ui) {
        ui.game.addMoney(ui.game.getSalary());
        ui.game.addExperience(EXPERIENCE_INCR_WHILE_WORK);
        ui.game.addMood(-MOOD_DROP_WHILE_WORK);
        ui.game.subApt(ActionType.EXTRA_WORK.getApt());
        ui.updateStatus();
    }

    public static void randomEvent(GameUI ui) {
        if (!Utils.isWeekend(ui.game) && Utils.isNight(ui.game)) {
            RandomEvent event = Rules.computeEveningEvent(ui.game.getLove());
            if (!event.equals(RandomEvent.NONE)) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, event.getDesc(), "偶然事件", JOptionPane.INFORMATION_MESSAGE);
                ui.game.addLove(event.getEffect());
            }
        }
    }
}
