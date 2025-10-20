package com.spike.vehicle.factory;

/**
 * 抽象的车辆接口，当需要新增不同车辆的种类，只需要再写一个新的具体工厂类实现接口就行
 * 定义了车辆的基本行为，包括 drive() 方法，用于返回车辆行驶的描述。
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public interface Vehicle {

    // 返回车辆行驶的描述
    public abstract String drive();
}
