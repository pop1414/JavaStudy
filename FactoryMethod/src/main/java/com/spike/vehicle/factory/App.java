package com.spike.vehicle.factory;

/**
 * 主程序类，用于演示工厂方法模式的使用。
 * 创建 BMW 和 Tesla 工厂，生成不同类型的车辆，并演示驾驶方法和异常处理。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class App {
    public static void main(String[] args) {
        BMWFactory bmwFactory = new BMWFactory();
        TeslaFactory teslaFactory = new TeslaFactory();

        Vehicle bmwCar = bmwFactory.createVehicle(VehicleType.CAR);
        Vehicle bmwMotorcycle = bmwFactory.createVehicle(VehicleType.MOTORCYCLE);

        Vehicle teslaCar = teslaFactory.createVehicle(VehicleType.CAR);
        Vehicle teslaBicycle = teslaFactory.createVehicle(VehicleType.BICYCLE);

        System.out.println(bmwCar.drive());
        System.out.println(bmwMotorcycle.drive());

        System.out.println(teslaCar.drive());
        System.out.println(teslaBicycle.drive());

        // 演示未知类型
        try {
            Vehicle undefined = teslaFactory.createVehicle(VehicleType.UNDEFINED);
            System.out.println("Undefined: " + undefined.drive());
        } catch (IllegalArgumentException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
