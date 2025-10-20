package com.spike.vehicle.factory;

/**
 * BMW 汽车类，实现 Vehicle 接口，提供 BMW 品牌的汽车实现。
 * 实现了 drive() 方法，返回驾驶 BMW 汽车的描述。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class BMWCar implements Vehicle {

    @Override
    public String drive() {
        return "Driving a BMW Car";
    }

    @Override
    public String toString() {
        return "BMWCar";
    }
}
