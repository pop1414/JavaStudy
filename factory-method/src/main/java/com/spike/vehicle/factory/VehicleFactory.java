package com.spike.vehicle.factory;

/**
 * 抽象的工厂接口，当需要新增不同的种类的工厂，只需要再写一个新的具体工厂类实现接口就行。
 * 定义了 createVehicle() 方法，根据车辆类型返回相应的 Vehicle 实例。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public interface VehicleFactory {


    /**
     * 传入车辆类型 VehicleType（枚举类），返回具体车辆 Vehicle
     *
     * @param type
     * @return {@code Vehicle }
     */
    public abstract Vehicle createVehicle(VehicleType type);
}
