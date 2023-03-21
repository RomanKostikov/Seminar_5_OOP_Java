package org.example.hw.model;

import java.util.List;

/**
 * Интерфейс торгового автомата
 */
public interface VendingMachine<T> {
    /**
     * Внесение продуктов в торговый автомат
     */
    void initProduct(List<T> list);

    /**
     * Получение продукта из торгового автомата
     *
     * @return строку
     */
    String getProduct(String name);
}
