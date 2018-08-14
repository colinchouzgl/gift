package io;

import commons.Utils;
import enums.ActionType;
import enums.Snack;
import enums.Tip;
import game.Game;

import java.util.List;
import java.util.Scanner;

/**
 * @author Zhou Guanliang
 * @since 2018/8/14
 */
public class ConsoleUtils implements IOUtils {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    @Override
    public void status(Game game) {
        System.out.println("--------------------");
        System.out.println(Utils.formatDateTime(game));

        System.out.print("Love: " + game.getLove() + ", ");
        System.out.print("Money: " + game.getMoney() + ", ");
        System.out.print("Mood: " + game.getMood() + ", ");
        System.out.print("Experience: " + game.getExperience() + ", ");
        System.out.println("Salary: " + game.getSalary());

        System.out.println("APT(" + game.getApt() + ")");
        System.out.println("--------------------");
    }

    @Override
    public void actionOptions(List<ActionType> options) {
        System.out.print("Choose：");
        for (int i = 0; i < options.size(); i++) {
            System.out.print((i + 1) + "-" + options.get(i).getDesc() + "(" + options.get(i).getApt() + "), ");
        }
        System.out.println();
    }

    @Override
    public void tip(Tip tip, Object... params) {
        System.out.println(String.format(tip.getDesc(), params));
    }

    @Override
    public void snackOptions(List<Snack> affordableSnacks, List<Snack> unaffordableSnacks) {
        if (affordableSnacks.size() > 0) {
            String optionLine = "Choose：";
            for (int i = 0; i < affordableSnacks.size(); i++) {
                Snack snack = affordableSnacks.get(i);
                optionLine += (i + 1) + "-" + snack.getDesc() + "(￥" + snack.getPrice() + ", mood+" + snack.getEffect() + ")  ";
            }
            if (affordableSnacks.size() > 0) {
                optionLine = optionLine.substring(0, optionLine.length() - 2);
            }
            System.out.println(optionLine);
        }

        if (unaffordableSnacks.size() > 0) {
            String lockedLine = "[";
            for (Snack snack : unaffordableSnacks) {
                lockedLine += snack.getDesc() + "(￥" + snack.getPrice() + ", mood+" + snack.getEffect() + ")  ";
            }
            if (unaffordableSnacks.size() > 0) {
                lockedLine = lockedLine.substring(0, lockedLine.length() - 2);
            }
            System.out.println(lockedLine + "]");
        }
    }

    @Override
    public int choose(List options) {
        while (true) {
            input = scanner.nextLine();
            try {
                int code = Integer.parseInt(input);
                if (code > 0 && code <= options.size()) {
                    return code;
                }
                System.out.println("Input error!");
            } catch (NumberFormatException e) {
                System.out.println("Input error!");
            }
        }
    }
}
