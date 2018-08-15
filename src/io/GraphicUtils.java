package io;

import commons.Utils;
import enums.ActionType;
import enums.Snack;
import enums.Tip;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class GraphicUtils implements IOUtils {
    private GameUI ui;

    public GraphicUtils(GameUI ui) {
        this.ui = ui;
    }

    @Override
    public void status(Game game) {
        ui.time.setText(Utils.formatDateTime(game));
        ui.loveValue.setText(String.valueOf(game.getLove()));
        ui.moneyValue.setText(String.valueOf(game.getMoney()));
        ui.moodValue.setText(String.valueOf(game.getMood()));
        ui.experienceValue.setText(String.valueOf(game.getExperience()));
        ui.salaryValue.setText(String.valueOf(game.getSalary()));
        ui.aptValue.setText(String.valueOf(game.getApt()));

        if (Utils.isWeekend(game)) {
            ui.work.setEnabled(false);
            ui.workOvertime.setEnabled(false);
            ui.rest.setEnabled(false);
            ui.eatSnack.setEnabled(false);
            ui.chat.setEnabled(false);
            ui.watchTV.setEnabled(false);
            ui.shopping.setEnabled(true);
            ui.travel.setEnabled(true);
            ui.watchMovie.setEnabled(true);
            ui.extraWork.setEnabled(true);
        } else {
            if (Utils.isNight(game)) {
                ui.work.setEnabled(false);
                ui.workOvertime.setEnabled(false);
                ui.rest.setEnabled(false);
                ui.eatSnack.setEnabled(true);
                ui.chat.setEnabled(true);
                ui.watchTV.setEnabled(true);
                ui.shopping.setEnabled(false);
                ui.travel.setEnabled(false);
                ui.watchMovie.setEnabled(false);
                ui.extraWork.setEnabled(false);
            } else {
                ui.work.setEnabled(true);
                ui.workOvertime.setEnabled(true);
                ui.rest.setEnabled(true);
                ui.eatSnack.setEnabled(false);
                ui.chat.setEnabled(false);
                ui.watchTV.setEnabled(false);
                ui.shopping.setEnabled(false);
                ui.travel.setEnabled(false);
                ui.watchMovie.setEnabled(false);
                ui.extraWork.setEnabled(false);
            }
        }
    }

    @Override
    public void tip(Tip tip, Object... params) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, String.format(tip.getDesc(), params), "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int choose(List options) {
        return 0;
    }

    @Override
    public void actionOptions(List<ActionType> options) {
    }

    @Override
    public void snackOptions(List<Snack> affordableSnacks, List<Snack> unaffordableSnacks) {
    }
}
