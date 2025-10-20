package com.spike.vehicle.factory;

/**
 *
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
