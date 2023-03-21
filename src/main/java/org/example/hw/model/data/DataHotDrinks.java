package org.example.hw.model.data;

import org.example.hw.model.HotDrinks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataHotDrinks {
    private List<HotDrinks> list;

    public DataHotDrinks() {
        this.list = importList();
    }

    /**
     * Считывание сохраненной базы данных из файла
     *
     * @return лист горячих напитков
     */
    private List<HotDrinks> importList() {
        List<HotDrinks> listOfHot = new ArrayList<>();
        File file = new File("dataHotDrinks.txt");
        try (FileReader reader = new FileReader(file)) {
            BufferedReader reader1 = new BufferedReader(reader);
            String line = reader1.readLine();
            while (line != null) {
                String[] lineArray = line.split(";");
                listOfHot.add(new HotDrinks(
                        lineArray[0],
                        Float.parseFloat(lineArray[1]),
                        Double.parseDouble(lineArray[2]),
                        Integer.parseInt(lineArray[3])));
                line = reader1.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfHot;
    }

    /**
     * Добавление продукта в список
     *
     * @param name        название продукта
     * @param price       цена продукта
     * @param value       обем продукта
     * @param temperature тепература продукта
     */
    public void addAtBase(String name, float price, double value, int temperature) {
        this.list.add(new HotDrinks(name, price, value, temperature));
    }

    /**
     * Метод записи базы данных в файл
     */
    public void exportBase() {
        File file = new File("dataHotDrinks.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (HotDrinks el : this.list) {
                writer.write(
                        el.getName() + ";" +
                                el.getPrice() + ";" +
                                el.getVolume() + ";" +
                                el.getTemp() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение листа напитков
     *
     * @return лист горячих напитков
     */
    public List<HotDrinks> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (HotDrinks el : list) {
            builder.append(el.toString()).append("\n");
        }
        return builder.toString();
    }
}
