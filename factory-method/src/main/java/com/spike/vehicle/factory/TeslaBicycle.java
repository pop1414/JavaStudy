package com.spike.vehicle.factory;

/**
 * Tesla 自行车类，实现 Vehicle 接口，提供 Tesla 品牌的自行车实现。
 * 实现了 drive() 方法，返回驾驶 Tesla 自行车的描述。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class TeslaBicycle implements Vehicle {

    @Override
    public String drive() {
        return "Driving a TeslaBicycle";
    }

    @Override
    public String toString() {
        return "TeslaBicycle";
    }
}
