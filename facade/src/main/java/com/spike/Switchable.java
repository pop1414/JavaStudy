package com.spike;

/**
 * 子系统能力抽象
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public interface Switchable {
    void switchOn();

    void switchOff();

    @Override
    String toString();
}
