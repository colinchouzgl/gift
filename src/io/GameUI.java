package io;

import commons.Utils;
import enums.options.FoodType;
import game.Actions;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class GameUI extends JFrame implements ActionListener {
    public Game game;

    public Container container;
    public JPanel mainPane;
    public JPanel itemPane;
    public JPanel foodPane;

    public JLabel time;
    public JLabel love;
    public JLabel loveValue;
    public JLabel money;
    public JLabel moneyValue;
    public JLabel mood;
    public JLabel moodValue;
    public JLabel experience;
    public JLabel experienceValue;
    public JLabel salary;
    public JLabel salaryValue;
    public JLabel apt;
    public JLabel aptValue;
    public JLabel itemTitle;
    public JLabel foodInfo;

    public JButton work;
    public JButton workOvertime;
    public JButton rest;
    public JButton eatSnack;
    public JButton chat;
    public JButton watchTV;
    public JButton shopping;
    public JButton hangAround;
    public JButton watchMovie;
    public JButton extraWork;
    public JButton stayHome;
    public JButton foodSubmit;

    public ButtonGroup snackGroup = new ButtonGroup();
    public ButtonGroup storedGroup = new ButtonGroup();
    public ButtonGroup goodsGroup = new ButtonGroup();
    public ButtonGroup clothesGroup = new ButtonGroup();
    public ButtonGroup foodGroup = new ButtonGroup();
    public ButtonGroup spotGroup = new ButtonGroup();
    public ButtonGroup travelSpotGroup = new ButtonGroup();

    public JDialog foodForm;

    public JTextField foodCount;

    public FoodType selectedFoodType = FoodType.get(1);

    public GameUI() {
        super();
        init();
    }

    private void init() {
        game = new Game();

        this.setSize(1000, 600);
        this.setTitle("和老公的小日子");

        container = this.getContentPane();
        container.setLayout(null);

        mainPane = new JPanel();
        mainPane.setLayout(null);
        mainPane.setBounds(1, 0, 999, 320);
        mainPane.setBorder(BorderFactory.createEtchedBorder());

        itemPane = new JPanel();
        itemPane.setLayout(null);
        itemPane.setBounds(1, 320, 999, 300);

        container.add(mainPane);
        container.add(itemPane);

        addLabel();
        addButton();
        addDialog();

        updateStatus();
    }

    private void addLabel() {
        //主面板
        time = new JLabel();
        time.setBounds(30, 10, 200, 40);
        time.setText(Utils.formatDateTime(game));
        time.setFont(new Font("黑体", Font.PLAIN, 24));
        mainPane.add(time);

        love = new JLabel();
        love.setBounds(70, 60, 280, 40);
        love.setText("甜蜜度:");
        love.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(love);

        loveValue = new JLabel();
        loveValue.setBounds(150, 60, 280, 40);
        loveValue.setText(String.valueOf(game.getLove()));
        loveValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(loveValue);

        money = new JLabel();
        money.setBounds(260, 60, 280, 40);
        money.setText("现金:");
        money.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(money);

        moneyValue = new JLabel();
        moneyValue.setBounds(320, 60, 280, 40);
        moneyValue.setText(String.valueOf(game.getMoney()));
        moneyValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(moneyValue);

        mood = new JLabel();
        mood.setBounds(430, 60, 280, 40);
        mood.setText("心情:");
        mood.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(mood);

        moodValue = new JLabel();
        moodValue.setBounds(490, 60, 280, 40);
        moodValue.setText(String.valueOf(game.getMood()));
        moodValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(moodValue);

        experience = new JLabel();
        experience.setBounds(600, 60, 280, 40);
        experience.setText("工作表现:");
        experience.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(experience);

        experienceValue = new JLabel();
        experienceValue.setBounds(700, 60, 280, 40);
        experienceValue.setText(String.valueOf(game.getExperience()));
        experienceValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(experienceValue);

        salary = new JLabel();
        salary.setBounds(790, 60, 280, 40);
        salary.setText("工资:");
        salary.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(salary);

        salaryValue = new JLabel();
        salaryValue.setBounds(850, 60, 280, 40);
        salaryValue.setText(String.valueOf(game.getSalary()) + "/天");
        salaryValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(salaryValue);

        apt = new JLabel();
        apt.setBounds(800, 10, 280, 40);
        apt.setText("剩余行动点数:");
        apt.setFont(new Font("黑体", Font.PLAIN, 20));
        mainPane.add(apt);

        aptValue = new JLabel();
        aptValue.setBounds(940, 10, 280, 40);
        aptValue.setText(String.valueOf(game.getApt()));
        aptValue.setFont(new Font("黑体", Font.PLAIN, 20));
        mainPane.add(aptValue);

        //副面板
        itemTitle = new JLabel();
        itemTitle.setBounds(60, 20, 280, 40);
        itemTitle.setFont(new Font("黑体", Font.PLAIN, 20));
        itemTitle.setVisible(false);
        itemPane.add(itemTitle);
    }

    private void addButton() {
        work = new JButton();
        work.setBounds(140, 120, 120, 40);
        work.setText("正常上班");
        work.setToolTipText("去上班，现金+，工作表现+，心情-");
        work.setFont(new Font("黑体", Font.PLAIN, 18));
        work.addActionListener(this);
        mainPane.add(work);

        workOvertime = new JButton();
        workOvertime.setBounds(140, 180, 120, 40);
        workOvertime.setText("加班");
        workOvertime.setToolTipText("加班到深夜，现金++，工作表现++，心情--");
        workOvertime.setFont(new Font("黑体", Font.PLAIN, 18));
        workOvertime.addActionListener(this);
        mainPane.add(workOvertime);

        rest = new JButton();
        rest.setBounds(140, 240, 120, 40);
        rest.setText("休息");
        rest.setToolTipText("在家休息，心情++");
        rest.setFont(new Font("黑体", Font.PLAIN, 18));
        rest.addActionListener(this);
        mainPane.add(rest);

        eatSnack = new JButton();
        eatSnack.setBounds(410, 120, 120, 40);
        eatSnack.setText("吃零食");
        eatSnack.setToolTipText("买零食吃，现金-，心情+");
        eatSnack.setFont(new Font("黑体", Font.PLAIN, 18));
        eatSnack.addActionListener(this);
        mainPane.add(eatSnack);

        chat = new JButton();
        chat.setBounds(410, 180, 120, 40);
        chat.setText("聊天");
        chat.setToolTipText("聊天");
        chat.setFont(new Font("黑体", Font.PLAIN, 18));
        chat.addActionListener(this);
        mainPane.add(chat);

        watchTV = new JButton();
        watchTV.setBounds(410, 240, 120, 40);
        watchTV.setText("看电视");
        watchTV.setToolTipText("看电视");
        watchTV.setFont(new Font("黑体", Font.PLAIN, 18));
        watchTV.addActionListener(this);
        mainPane.add(watchTV);

        shopping = new JButton();
        shopping.setBounds(640, 120, 120, 40);
        shopping.setText("逛商场");
        shopping.setToolTipText("买买买，现金-，心情+");
        shopping.setFont(new Font("黑体", Font.PLAIN, 18));
        shopping.addActionListener(this);
        mainPane.add(shopping);

        hangAround = new JButton();
        hangAround.setBounds(640, 180, 120, 40);
        hangAround.setText("出去玩");
        hangAround.setToolTipText("出去玩，现金-，心情+，甜蜜度+");
        hangAround.setFont(new Font("黑体", Font.PLAIN, 18));
        hangAround.addActionListener(this);
        mainPane.add(hangAround);

        watchMovie = new JButton();
        watchMovie.setBounds(640, 240, 120, 40);
        watchMovie.setText("去看电影");
        watchMovie.setToolTipText("看电影，现金-，心情+，甜蜜度+");
        watchMovie.setFont(new Font("黑体", Font.PLAIN, 18));
        watchMovie.addActionListener(this);
        mainPane.add(watchMovie);

        extraWork = new JButton();
        extraWork.setBounds(770, 120, 120, 40);
        extraWork.setText("在家加班");
        extraWork.setToolTipText("周末在家加班，现金++，工作表现++，心情--");
        extraWork.setFont(new Font("黑体", Font.PLAIN, 18));
        extraWork.addActionListener(this);
        mainPane.add(extraWork);

        stayHome = new JButton();
        stayHome.setBounds(770, 180, 120, 40);
        stayHome.setText("在家呆着");
        stayHome.setToolTipText("啥也不干");
        stayHome.setFont(new Font("黑体", Font.PLAIN, 18));
        stayHome.addActionListener(this);
        mainPane.add(stayHome);
    }

    private void addDialog() {
        foodForm = new JDialog(this, true);
        foodForm.setTitle("购买食品");
        foodForm.setSize(450, 250);

        foodPane = new JPanel();
        foodPane.setLayout(null);
        foodPane.setBounds(1, 0, 449, 250);
        foodForm.setContentPane(foodPane);

        foodInfo = new JLabel();
        foodInfo.setBounds(40, 40, 400, 30);
        foodInfo.setFont(new Font("黑体", Font.PLAIN, 18));
        foodPane.add(foodInfo);

        foodCount = new JTextField();
        foodCount.setBounds(80, 100, 200, 40);
        foodCount.setFont(new Font("黑体", Font.PLAIN, 15));
        foodPane.add(foodCount);

        foodSubmit = new JButton("确定");
        foodSubmit.setBounds(300, 100, 80, 40);
        foodSubmit.setFont(new Font("黑体", Font.PLAIN, 14));
        foodSubmit.addActionListener(this);
        foodPane.add(foodSubmit);

        foodForm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        foodForm.setResizable(false);
        foodForm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == work) {
            Actions.work(this);
        } else if (e.getSource() == workOvertime) {
            Actions.workOvertime(this);
        } else if (e.getSource() == rest) {
            Actions.rest(this);
        } else if (e.getSource() == eatSnack) {
            Actions.showSnack(this);
        } else if (e.getSource() == chat) {
            Actions.chat(this);
        } else if (e.getSource() == watchTV) {
            Actions.watchTV(this);
        } else if (e.getSource() == shopping) {
            Actions.showGoods(this);
        } else if (e.getSource() == hangAround) {
            Actions.showSpot(this);
        } else if (e.getSource() == watchMovie) {
            Actions.watchMovie(this);
        } else if (e.getSource() == extraWork) {
            Actions.extraWork(this);
        } else if (e.getSource() == stayHome) {
            Actions.stayHome(this);
        } else if (e.getSource() == foodSubmit) {
            Actions.buyFood(this);
        } else if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();

            Enumeration<AbstractButton> snackButtons = snackGroup.getElements();
            while (snackButtons.hasMoreElements()) {
                AbstractButton button = snackButtons.nextElement();
                if (button.equals(source)) {
                    if ("snack9".equals(button.getName())) {
                        updateStatus();
                        Actions.showStored(this);
                        break;
                    } else {
                        Actions.eatSnack(this, source);
                        break;
                    }
                }
            }

            Enumeration<AbstractButton> storedButtons = storedGroup.getElements();
            while (storedButtons.hasMoreElements()) {
                AbstractButton button = storedButtons.nextElement();
                if (button.equals(source)) {
                    Actions.eatStored(this, source);
                    break;
                }
            }

            Enumeration<AbstractButton> goodsButtons = goodsGroup.getElements();
            while (goodsButtons.hasMoreElements()) {
                AbstractButton button = goodsButtons.nextElement();
                if (button.equals(source)) {
                    if ("goods7".equals(button.getName())) {
                        updateStatus();
                        Actions.showClothes(this);
                        break;
                    } else if ("goods8".equals(button.getName())) {
                        updateStatus();
                        Actions.showFood(this);
                        break;
                    } else {
                        Actions.shopping(this, source);
                        break;
                    }
                }
            }

            Enumeration<AbstractButton> foodButtons = foodGroup.getElements();
            while (foodButtons.hasMoreElements()) {
                AbstractButton button = foodButtons.nextElement();
                if (button.equals(source)) {
                    updateStatus();
                    selectedFoodType = FoodType.get(Integer.parseInt(button.getName().replaceAll("food", "")));
                    foodInfo.setText("请填写购买数量：（" + selectedFoodType.getDesc() + " 单价" + selectedFoodType.getPrice() + "）");
                    foodCount.setText("");
                    foodForm.setVisible(true);
                    break;
                }
            }

            Enumeration<AbstractButton> spotButtons = spotGroup.getElements();
            while (spotButtons.hasMoreElements()) {
                AbstractButton button = spotButtons.nextElement();
                if (button.equals(source)) {
                    if ("spot6".equals(button.getName())) {
                        updateStatus();
                        Actions.showTravelSpot(this);
                        break;
                    } else {
                        Actions.hangAround(this, source);
                        break;
                    }
                }
            }

            Enumeration<AbstractButton> clothesButtons = clothesGroup.getElements();
            while (clothesButtons.hasMoreElements()) {
                AbstractButton button = clothesButtons.nextElement();
                if (button.equals(source)) {
                    Actions.buyClothes(this, source);
                    break;
                }
            }

            Enumeration<AbstractButton> travelSpotButtons = travelSpotGroup.getElements();
            while (travelSpotButtons.hasMoreElements()) {
                AbstractButton button = travelSpotButtons.nextElement();
                if (button.equals(source)) {
                    Actions.travel(this, source);
                    break;
                }
            }
        }

        if (game.getApt() == 0) {
            game.timePass();
            Actions.randomEvent(this);
            updateStatus();
        }
    }

    public void updateStatus() {
        time.setText(Utils.formatDateTime(game));
        loveValue.setText(String.valueOf(game.getLove()));
        moneyValue.setText(String.valueOf(game.getMoney()));
        moodValue.setText(String.valueOf(game.getMood()));
        experienceValue.setText(String.valueOf(game.getExperience()));
        salaryValue.setText(String.valueOf(game.getSalary()));
        aptValue.setText(String.valueOf(game.getApt()));

        removeGroup(snackGroup);
        removeGroup(storedGroup);
        removeGroup(goodsGroup);
        removeGroup(clothesGroup);
        removeGroup(foodGroup);
        removeGroup(spotGroup);
        removeGroup(travelSpotGroup);

        itemTitle.setVisible(false);
        itemPane.repaint();

        if (Utils.isWeekend(game)) {
            work.setEnabled(false);
            workOvertime.setEnabled(false);
            rest.setEnabled(false);
            eatSnack.setEnabled(false);
            chat.setEnabled(false);
            watchTV.setEnabled(false);
            shopping.setEnabled(true);
            hangAround.setEnabled(true);
            watchMovie.setEnabled(true);
            extraWork.setEnabled(true);
            stayHome.setEnabled(true);
        } else {
            if (Utils.isNight(game)) {
                work.setEnabled(false);
                workOvertime.setEnabled(false);
                rest.setEnabled(false);
                eatSnack.setEnabled(true);
                chat.setEnabled(true);
                watchTV.setEnabled(true);
                shopping.setEnabled(false);
                hangAround.setEnabled(false);
                watchMovie.setEnabled(false);
                extraWork.setEnabled(false);
                stayHome.setEnabled(false);
            } else {
                work.setEnabled(true);
                workOvertime.setEnabled(true);
                rest.setEnabled(true);
                eatSnack.setEnabled(false);
                chat.setEnabled(false);
                watchTV.setEnabled(false);
                shopping.setEnabled(false);
                hangAround.setEnabled(false);
                watchMovie.setEnabled(false);
                extraWork.setEnabled(false);
                stayHome.setEnabled(false);
            }
        }

        foodForm.setVisible(false);
    }

    private void removeGroup(ButtonGroup group) {
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            itemPane.remove(button);
        }
//        group = new ButtonGroup();
    }
}
