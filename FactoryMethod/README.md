# Vehicle Factory Method Pattern

## Overview

This project demonstrates the **Factory Method** design pattern in Java. It provides an abstract factory interface for
creating vehicles of different types (e.g., cars, motorcycles, bicycles) from various manufacturers (BMW and Tesla). The
pattern allows for easy extension of new vehicle types or manufacturers without modifying existing code.

The code follows object-oriented principles, using interfaces for abstraction and enums for vehicle types. It includes a
main application class to showcase the creation and usage of vehicles.

## Project Structure

- **Vehicle.java**: Interface defining the abstract vehicle with a `drive()` method.
- **VehicleFactory.java**: Interface for the abstract factory, with a `createVehicle(VehicleType type)` method.
- **VehicleType.java**: Enum representing vehicle types (CAR, BICYCLE, MOTORCYCLE, UNDEFINED).
- **BMWFactory.java**: Concrete factory for BMW vehicles, supporting CAR and MOTORCYCLE.
- **TeslaFactory.java**: Concrete factory for Tesla vehicles, supporting CAR and BICYCLE.
- **BMWCar.java**: Concrete BMW car implementation.
- **BMWMotorcycle.java**: Concrete BMW motorcycle implementation.
- **TeslaCar.java**: Concrete Tesla car implementation.
- **TeslaBicycle.java**: Concrete Tesla bicycle implementation.
- **App.java**: Main application class demonstrating factory usage and handling unsupported types with exceptions.

All classes are in the package `com.spike.vehicle.factory`.

## UML

(https://www.plantuml.com/plantuml/svg/fPBFQW8n4CRl-nHpN2dT1-YXgAk2K1MiRIdYOHf76yp-8PaLnFhkJRl6DQ6bXJtiOJFVzyitC-aQHirLfg8InGwt1AB84bFA7ILxUfT2KR91mOK-m34240gDWLvPVly1t426CezHRmtSmIDhcM-NgmuSBPUbE5dHroTp9cqv1Cyrz69VQxcdk7Cnmn7V36iKxBoKLvcpBGvbOqrxy-QU-gW_Jb_JXs5uF9ajPlCVAq_JmN0qdWu7Vk4MMBAYIwgpcelwD-w4bJsgYcQRECUiSLcL5xovel6OE50jLtyER-GMSWO9JSXqBiPi8JxowePml6wZ_SbB2wg7Mf1Hs0OMv4fHXw_bFti9A9F2vX47eQWLpFNNDfJZz6MhJAVeQd59yd4VF978BUDNGJrWhnJvu_9AhldmrBKIwhkKhwjCVG80)

## Design Pattern Explanation

The Factory Method pattern is used here to:

- Decouple object creation from specific classes.
- Allow subclasses (concrete factories) to decide which class to instantiate.
- Handle unsupported vehicle types by throwing `IllegalArgumentException`.

This promotes flexibility: To add a new manufacturer (e.g., Ford), implement `VehicleFactory` and add concrete vehicle
classes. To add a new vehicle type (e.g., TRUCK), update the enum and factories accordingly.

## Prerequisites

- Java Development Kit (JDK) 8 or higher.
- A Java compiler (e.g., `javac`) and runtime (e.g., `java`).

## How to Compile and Run

1. Clone or download the project.
2. Navigate to the project directory.
3. Compile the Java files:
   ```
   javac com/spike/vehicle/factory/*.java
   ```
4. Run the main application:
   ```
   java com.spike.vehicle.factory.App
   ```

### Expected Output

```
Driving a BMW Car
Driving a BMWMotorcycle
Driving a Tesla Car
Driving a TeslaBicycle
Handled: Unsupported vehicle type: UNDEFINED
```

This demonstrates creating vehicles from factories and handling an undefined type with an exception.

## Extending the Project

- **Add a New Factory**: Create a class implementing `VehicleFactory` and override `createVehicle()`.
- **Add a New Vehicle Type**: Add to `VehicleType` enum and update switch statements in factories.
- **Error Handling**: Factories throw exceptions for unsupported types, which are caught in the demo.

## Author

- Ayanami
- Date: 2025/10/20

## License

This project is for educational purposes and is unlicensed. Feel free to use and modify as needed.