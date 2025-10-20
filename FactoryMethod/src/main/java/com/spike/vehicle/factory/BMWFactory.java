package com.spike.vehicle.factory;

/**
 * BMW 车辆的具体工厂类，实现 VehicleFactory 接口，用于创建 BMW 品牌的车辆
 * 根据传入的车辆类型，返回相应的 BMW 车辆实例。如果类型不支持，则抛出 IllegalArgumentException。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class BMWFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case CAR:
                return new BMWCar();
            case MOTORCYCLE:
                return new BMWMotorcycle();
            default:
                // ← 改成抛异常
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }
}
