package com.spike;

/**
 * 子系统角色
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public class Fan implements FanLike {
    @Override
    public void setSpeed(int level) {
        System.out.println("Fan Spend " + level);
    }

    @Override
    public void switchOn() {
        System.out.println("Fan On");
    }

    @Override
    public void switchOff() {
        System.out.println("Fan Off");
    }

    @Override
    public String toString() {
        return "Fan";
    }
}
