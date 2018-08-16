import io.GameUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class Launcher {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 15)));
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 15)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameUI ui = new GameUI();
        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ui.setVisible(true);
        ui.setResizable(false);
        ui.setLocationRelativeTo(null);

        ui.updateStatus();
    }
}
