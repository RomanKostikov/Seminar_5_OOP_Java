package org.example.hw.service;


import org.example.hw.model.*;
import org.example.hw.model.data.DataBottleOfWater;
import org.example.hw.model.data.DataHotDrinks;
import org.example.hw.view.ConsoleUserInterface;


public class UserServiceImpl implements UserService {
    public void start() {
        ConsoleUserInterface consoleUI = new ConsoleUserInterface();
        consoleUI.printMainMenu();
        String choice = consoleUI.setChoice("Выберите пункт");
        while (!choice.equalsIgnoreCase("4")) {
            switch (choice) {
                case "1" -> addProduct(consoleUI);
                case "2" -> findProduct(consoleUI);
                case "3" -> printListProduct(consoleUI);
                default -> consoleUI.printMessage("Не корректный ввод!");
            }
            consoleUI.printMessage("\n");
            consoleUI.printMainMenu();
            choice = consoleUI.setChoice("Выберите пункт");
        }
    }

    /**
     * Метод добавления продуктов в базы хранения
     *
     * @param consoleUI
     */
    private void addProduct(ConsoleUserInterface consoleUI) {
        consoleUI.printAddMenu();
        String ch = consoleUI.setChoice("Выберите пункт");
        if (ch.equalsIgnoreCase("1")) { // Бутилированный напиток
            DataBottleOfWater baseBW = new DataBottleOfWater();
            baseBW.addAtBase(
                    consoleUI.setChoice("Введите название"),
                    Float.parseFloat(consoleUI.setChoice("Введите цену").replace(',', '.')),
                    Double.parseDouble(consoleUI.setChoice("Введите объем").replace(',', '.')));
            baseBW.exportBase();
        } else if (ch.equalsIgnoreCase("2")) { // Горячий напиток
            DataHotDrinks baseHT = new DataHotDrinks();
            baseHT.addAtBase(
                    consoleUI.setChoice("Введите название"),
                    Float.parseFloat(consoleUI.setChoice("Введите цену").replace(',', '.')),
                    Double.parseDouble(consoleUI.setChoice("Введите объем").replace(',', '.')),
                    Integer.parseInt(consoleUI.setChoice("Введите температуру")));
            baseHT.exportBase();
        } else {
            consoleUI.printMessage("Не корректный ввод!");
        }
    }

    /**
     * Метод получения продуктов из торгового аппарата
     *
     * @param consoleUI
     */
    private void findProduct(ConsoleUserInterface consoleUI) {
        consoleUI.printAddMenu();
        String ch = consoleUI.setChoice("Выберите пункт");
        if (ch.equalsIgnoreCase("1")) {
            VendingMachineAllProducts<BottleOfWater> vendListBottle = new VendingMachineAllProducts<>();
            DataBottleOfWater baseBottleOfWater = new DataBottleOfWater();
            vendListBottle.initProduct(baseBottleOfWater.getList());

            consoleUI.printBottleMenu();
            String chMenu = consoleUI.setChoice("Выберите пункт");
            if (chMenu.equalsIgnoreCase("1")) {
                consoleUI.printMessage(vendListBottle.getProduct(consoleUI.setChoice("Введите название")));
            } else if (chMenu.equalsIgnoreCase("2")) {
                consoleUI.printMessage("Будет выведен список продуктов равный или меньше указанной цены!");
                consoleUI.printMessage(vendListBottle.getProduct(Float.parseFloat(consoleUI.setChoice("Введите цену"))));
            } else consoleUI.printMessage("Не корректный ввод!");

        } else if (ch.equalsIgnoreCase("2")) {
            VendingMachineAllProducts<HotDrinks> vendListHot = new VendingMachineAllProducts<>();
            DataHotDrinks baseHotDrinks = new DataHotDrinks();
            vendListHot.initProduct(baseHotDrinks.getList());

            consoleUI.printHotMenu();
            String chMenu = consoleUI.setChoice("Выберите пункт");
            if (chMenu.equalsIgnoreCase("1")) {
                consoleUI.printMessage(vendListHot.getProduct(consoleUI.setChoice("Введите название")));
            } else if (chMenu.equalsIgnoreCase("2")) {
                consoleUI.printMessage("Будет выведен список продуктов равный или меньше указанной цены!");
                consoleUI.printMessage(vendListHot.getProduct(Float.parseFloat(consoleUI.setChoice("Введите цену"))));
            } else if (chMenu.equalsIgnoreCase("3")) {
                consoleUI.printMessage("Будет выведен список продуктов равный или меньше указанной тепературы!");
                consoleUI.printMessage(vendListHot.getProduct(Integer.parseInt(consoleUI.setChoice("Введите температуру"))));
            } else {
                consoleUI.printMessage("Не корректный ввод!");
            }
        } else {
            consoleUI.printMessage("Не корректный ввод!");
        }
    }

    /**
     * Печать списка продуктов
     *
     * @param consoleUI
     */
    private void printListProduct(ConsoleUserInterface consoleUI) {
        consoleUI.printAddMenu();
        String ch = consoleUI.setChoice("Выберите пункт");
        if (ch.equalsIgnoreCase("1")) {
            DataBottleOfWater baseBottleOfWater = new DataBottleOfWater();
            consoleUI.printMessage(baseBottleOfWater.toString());
        } else if (ch.equalsIgnoreCase("2")) {
            DataHotDrinks baseHotDrinks = new DataHotDrinks();
            consoleUI.printMessage(baseHotDrinks.toString());
        } else consoleUI.printMessage("Не корректный ввод!");
    }
}
