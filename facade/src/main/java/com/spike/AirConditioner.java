package com.spike;

/**
 * 子系统角色
 *
 * @author Ayanami
 * @date 2025/10/30
 */

public class AirConditioner implements AirConLike {
    @Override
    public void coolMode() {
        System.out.println("cool mode");
    }

    @Override
    public void setTemp(double temperature) {
        System.out.println("set temperature" + temperature);
    }

    @Override
    public void switchOn() {
        System.out.println("AC + switch on");
    }

    @Override
    public void switchOff() {
        System.out.println("AC + switch off");
    }

    @Override
    public String toString() {
        return "AirConditioner";
    }
}
