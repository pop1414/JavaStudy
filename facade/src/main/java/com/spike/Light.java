package com.spike;


/**
 * 子系统角色
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public class Light implements Dimmable {
    private final int id;

    public Light(int id) {
        this.id = id;
    }

    @Override
    public void switchOn() {
        System.out.println("Light" + id + " Switch On");
    }

    @Override
    public void switchOff() {
        System.out.println("Light" + id + " Switch Off");
    }

    @Override
    public void dim(int percent) {
        System.out.println("Light" + id + " Dimmable " + percent + "%");
    }

    @Override
    public String toString() {
        return "Light" + id;
    }
}
