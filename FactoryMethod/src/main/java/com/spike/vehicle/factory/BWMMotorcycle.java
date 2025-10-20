package com.spike.vehicle.factory;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class BWMMotorcycle implements Vehicle {

    @Override
    public String drive() {
        return "Driving a BWMMotorcycle";
    }

    @Override
    public String toString() {
        return "BWMMotorcycle";
    }
}
