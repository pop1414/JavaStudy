package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Milk implements Addition {
    @Override
    public double getPrice() {
        return 0.5;
    }

    @Override
    public String getDescription() {
        return " Milk ";
    }
}
