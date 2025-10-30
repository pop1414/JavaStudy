package com.spike;

/**
 * 子系统角色
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public class Tv implements TvLike {
    @Override
    public void setInput(String source) {
        System.out.println("Tv has been set up" + source);
    }

    @Override
    public void switchOn() {
        System.out.println("Tv has been switched on");
    }

    @Override
    public void switchOff() {
        System.out.println("Tv has been switched off");
    }

    @Override
    public String toString() {
        return "Tv";
    }
}
