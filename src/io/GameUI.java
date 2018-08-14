package io;

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
        Game game=new Game();
        init();
    }

    private void init() {
        this.setSize(700, 450);
        this.setTitle("TEST");

        container = this.getContentPane();
        container.setLayout(null);

        mainPane = new JPanel();
        mainPane.setLayout(null);
        mainPane.setBounds(1, 0, 699, 180);
        mainPane.setBorder(BorderFactory.createEtchedBorder());

        itemPane = new JPanel();
        itemPane.setLayout(null);
        itemPane.setPreferredSize(new Dimension(699, 1200));

        container.add(mainPane);
        container.add(itemPane);

        addLabel();
    }

    private void addLabel() {
        //主面板
        time = new JLabel();
        time.setBounds(260, 10, 280, 40);
        time.setText("");
        time.setFont(new Font("黑体", Font.PLAIN, 25));
        mainPane.add(time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == buttonNewItem) {
//
//        }
    }
}
