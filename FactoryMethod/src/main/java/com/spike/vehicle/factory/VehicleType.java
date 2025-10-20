package com.spike.vehicle.factory;

/**
 * 车辆类型枚举类，用于定义不同的车辆类型。
 * 每个枚举值包含一个标题字符串，并重写了 toString() 方法返回标题。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public enum VehicleType {
    CAR("car"),
    BICYCLE("bicycle"),
    MOTORCYCLE("motorcycle"),
    UNDEFINED("");

    // 枚举示例是全局单例，属性一旦构造就永改不掉，所以用final
    public final String title;

    private VehicleType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
