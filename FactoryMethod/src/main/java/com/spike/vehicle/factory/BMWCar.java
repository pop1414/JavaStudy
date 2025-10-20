package com.spike.vehicle.factory;

/**
 *
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
