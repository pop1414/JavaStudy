package com.spike.vehicle.factory;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class BWMCar implements Vehicle {

    @Override
    public String drive() {
        return "Driving a TeslaBicycle";
    }

    @Override
    public String toString() {
        return "BWMCar";
    }
}
