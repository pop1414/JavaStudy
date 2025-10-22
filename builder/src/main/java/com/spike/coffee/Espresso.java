package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Espresso implements Base {
    @Override
    public double getPrice() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return " Espresso ";
    }
}
