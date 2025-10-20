package com.spike.vehicle.factory;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class TeslaCar implements Vehicle {

    @Override
    public String drive() {
        return "Driving a Tesla Car";
    }

    @Override
    public String toString() {
        return "Tesla Car";
    }
}
