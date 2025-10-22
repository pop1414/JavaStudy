package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Tea implements Base {
    @Override
    public double getPrice() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return " Tea ";
    }
}
