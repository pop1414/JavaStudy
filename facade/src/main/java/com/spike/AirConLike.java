package com.spike;

/**
 * 窄接口
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public interface AirConLike extends Switchable {
    void coolMode();

    void setTemp(double temperature);
}
