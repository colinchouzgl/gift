import game.Game;
import io.GameUI;

import javax.swing.*;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Launcher {
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

        ui.updateStatus();
    }
}
