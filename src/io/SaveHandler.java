package io;

import enums.options.FoodType;
import game.Food;
import game.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/8/17
 */
public class SaveHandler {
    public static void save(Game game, String filePath) {
        String sav = "#money#" + game.getMoney() + "\n" +
                "#mood#" + game.getMood() + "\n" +
                "#love#" + game.getLove() + "\n" +
                "#experience#" + game.getExperience() + "\n" +
                "#salary#" + game.getSalary() + "\n" +
                "#date#" + game.getDate() + "\n" +
                "#time#" + game.getTime() + "\n" +
                "#apt#" + game.getApt() + "\n" +
                "@foodList@\n";
        for (Food food : game.getFoodList()) {
            sav += food.getType().getValue() + "-" + food.getClass() + "\n";
        }
        writeStrToTxtFile(filePath, sav, false);
    }

    public static void load(String filePath, GameUI ui) {
        Game game = new Game();
        try {
            List<Food> foodList = new ArrayList<>();

            String sav = readStrFromTxtFile(filePath);
            String[] lines = sav.split("\n");

            boolean isFoodList = false;
            for (String line : lines) {
                if (line.startsWith("#")) {
                    String[] parts = line.split("#");
                    switch (parts[1]) {
                        case "money":
                            game.setMoney(Integer.parseInt(parts[2]));
                            break;
                        case "mood":
                            game.setMood(Integer.parseInt(parts[2]));
                            break;
                        case "love":
                            game.setLove(Integer.parseInt(parts[2]));
                            break;
                        case "experience":
                            game.setExperience(Integer.parseInt(parts[2]));
                            break;
                        case "salary":
                            game.setSalary(Integer.parseInt(parts[2]));
                            break;
                        case "date":
                            game.setDate(Integer.parseInt(parts[2]));
                            break;
                        case "time":
                            game.setTime(Integer.parseInt(parts[2]));
                            break;
                        case "apt":
                            game.setApt(Integer.parseInt(parts[2]));
                            break;
                        default:
                    }
                } else if (line.startsWith("@")) {
                    if ("foodList".equals(line.replaceAll("@", ""))) {
                        isFoodList = true;
                    }
                } else {
                    if (isFoodList) {
                        String[] parts = line.split("-");
                        Food food = new Food(FoodType.get(Integer.parseInt(parts[0])), Integer.parseInt(parts[1]));
                        foodList.add(food);
                    }
                }
            }
            game.setFoodList(foodList);
        } catch (Exception e) {
            if (!filePath.endsWith(".sav")) {
                filePath += ".sav";
            }
            save(game, filePath);
        }
        ui.savPath = filePath;
        ui.game = game;
    }


    public static String readStrFromTxtFile(String filePath) throws IOException {
        String content = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            content += line + "\n";
        }
        br.close();
        return content;
    }

    private static void writeStrToTxtFile(String filePath, String content, boolean notFold) {
        try {
            FileWriter writer = new FileWriter(filePath, notFold);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
