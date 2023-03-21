package org.example.hw.model;


/**
 * Класс напитков
 */
public class Drinkables extends Product {
    private Double volume;

    /**
     * Переопределенный конструктор напитков
     *
     * @param name   наименование напитка
     * @param price  цена напитка
     * @param volume объем напитка
     */
    public Drinkables(String name, float price, Double volume) {
        super(name, price);
        this.volume = volume;
    }

    /**
     * Получение объема напитка
     *
     * @return объем напитка
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Переопределенный метод
     *
     * @return наименование продукта, его стоимость и объем;
     */
    @Override
    public String toString() {
        return super.toString() + "объем = " + volume + " ";
    }

}
