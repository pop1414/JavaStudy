package com.spike.vehicle.factory;

/**
 * BMW 摩托车类，实现 Vehicle 接口，提供 BMW 品牌的摩托车实现。
 * 实现了 drive() 方法，返回驾驶 BMW 摩托车的描述。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class BMWMotorcycle implements Vehicle {

    @Override
    public String drive() {
        return "Driving a BMWMotorcycle";
    }

    @Override
    public String toString() {
        return "BMWMotorcycle";
    }
}
