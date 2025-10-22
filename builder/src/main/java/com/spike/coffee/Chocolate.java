package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Chocolate implements Addition {
    @Override
    public double getPrice() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return " Chocolate ";
    }
}
