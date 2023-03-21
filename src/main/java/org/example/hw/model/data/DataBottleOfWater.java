package org.example.hw.model.data;


import org.example.hw.model.BottleOfWater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataBottleOfWater {
    private List<BottleOfWater> list;

    public DataBottleOfWater() {
        this.list = importList();
    }

    /**
     * Считывание сохраненной базы данных из файла
     *
     * @return лист бутилированных напитков
     */
    private List<BottleOfWater> importList() {
        List<BottleOfWater> listOfBottle = new ArrayList<>();
        File file = new File("dataBottleOfWatter.txt");
        try (FileReader reader = new FileReader(file)) {
            BufferedReader reader1 = new BufferedReader(reader);
            String line = reader1.readLine();
            while (line != null) {
                String[] lineArray = line.split(";");
                listOfBottle.add(new BottleOfWater(
                        lineArray[0],
                        Float.parseFloat(lineArray[1]),
                        Double.parseDouble(lineArray[2])));
                line = reader1.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfBottle;
    }

    /**
     * Добавление в лист бутилированных напитков
     *
     * @param name  наименование продукта
     * @param price цена продукта
     * @param value объем продукта
     */
    public void addAtBase(String name, float price, double value) {
        this.list.add(new BottleOfWater(name, price, value));
    }

    /**
     * Сохранение базы данных бутилированных напитков в файл
     */
    public void exportBase() {
        File file = new File("dataBottleOfWatter.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (BottleOfWater el : this.list) {
                writer.write(el.getName() + ";" + el.getPrice() + ";" + el.getVolume() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение листа бутилированных напитков
     *
     * @return лист бутилированных напитков
     */
    public List<BottleOfWater> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (BottleOfWater el : list) {
            builder.append(el.toString()).append("\n");
        }
        return builder.toString();
    }
}
