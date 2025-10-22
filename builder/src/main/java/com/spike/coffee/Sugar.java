package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Sugar implements Addition {
    @Override
    public double getPrice() {
        return 0.3;
    }

    @Override
    public String getDescription() {
        return " Sugar ";
    }
}
