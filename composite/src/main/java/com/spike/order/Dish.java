package com.spike.order;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 叶子节点，没有子节点
 *
 * @author Ayanami
 * @date 2025/10/28
 */
public class Dish implements MenuComponent {
    private final String name;
    private final int price;
    private final boolean vegetarian;

    Dish(String name, int price, boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(price).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print(String indent) {
        String tag = vegetarian ? " (V)" : "";
        System.out.println(indent + name + tag + " 价格: " + price);
    }

}

