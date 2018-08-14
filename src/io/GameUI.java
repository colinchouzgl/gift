package io;

import commons.Utils;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class GameUI extends JFrame implements ActionListener {
    private Container container;
    private JPanel mainPane;
    private JPanel itemPane;

    private JLabel time;
    private JLabel love;
    private JLabel loveValue;
    private JLabel money;
    private JLabel moneyValue;
    private JLabel mood;
    private JLabel moodValue;
    private JLabel experience;
    private JLabel experienceValue;
    private JLabel salary;
    private JLabel salaryValue;
    private JLabel apt;
    private JLabel aptValue;

    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        GameUI ui = new GameUI();
        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ui.setVisible(true);
        ui.setResizable(false);
        ui.setLocationRelativeTo(null);
    }

    GameUI() {
        super();
        Game game = new Game();
        init(game);
    }

    private void init(Game game) {
        this.setSize(800, 600);
        this.setTitle("TEST");

        container = this.getContentPane();
        container.setLayout(null);

        mainPane = new JPanel();
        mainPane.setLayout(null);
        mainPane.setBounds(1, 0, 799, 300);
        mainPane.setBorder(BorderFactory.createEtchedBorder());

        itemPane = new JPanel();
        itemPane.setLayout(null);
        itemPane.setPreferredSize(new Dimension(799, 1200));

        container.add(mainPane);
        container.add(itemPane);

        addLabel(game);
    }

    private void addLabel(Game game) {
        //主面板
        time = new JLabel();
        time.setBounds(30, 10, 280, 40);
        time.setText(Utils.formatDateTime(game));
        time.setFont(new Font("黑体", Font.PLAIN, 24));
        mainPane.add(time);

        love = new JLabel();
        love.setBounds(50, 60, 280, 40);
        love.setText("甜蜜度:");
        love.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(love);

        loveValue = new JLabel();
        loveValue.setBounds(130, 60, 280, 40);
        loveValue.setText(String.valueOf(game.getLove()));
        loveValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(loveValue);

        money = new JLabel();
        money.setBounds(200, 60, 280, 40);
        money.setText("现金:");
        money.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(money);

        moneyValue = new JLabel();
        moneyValue.setBounds(260, 60, 280, 40);
        moneyValue.setText(String.valueOf(game.getMoney()));
        moneyValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(moneyValue);

        mood = new JLabel();
        mood.setBounds(330, 60, 280, 40);
        mood.setText("心情:");
        mood.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(mood);

        moodValue = new JLabel();
        moodValue.setBounds(390, 60, 280, 40);
        moodValue.setText(String.valueOf(game.getMood()));
        moodValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(moodValue);

        experience = new JLabel();
        experience.setBounds(460, 60, 280, 40);
        experience.setText("工作表现:");
        experience.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(experience);

        experienceValue = new JLabel();
        experienceValue.setBounds(560, 60, 280, 40);
        experienceValue.setText(String.valueOf(game.getExperience()));
        experienceValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(experienceValue);

        salary = new JLabel();
        salary.setBounds(620, 60, 280, 40);
        salary.setText("工资:");
        salary.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(salary);

        salaryValue = new JLabel();
        salaryValue.setBounds(680, 60, 280, 40);
        salaryValue.setText(String.valueOf(game.getSalary())+"/天");
        salaryValue.setFont(new Font("黑体", Font.PLAIN, 22));
        mainPane.add(salaryValue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == buttonNewItem) {
//
//        }
    }
}
