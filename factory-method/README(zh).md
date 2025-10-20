# 车辆工厂方法模式

## 概述

此项目演示了 Java 中的**工厂方法**设计模式。它提供了一个抽象工厂接口，用于从不同制造商（BMW 和
Tesla）创建不同类型的车辆（例如，汽车、摩托车、自行车）。该模式允许轻松扩展新的车辆类型或制造商，而无需修改现有代码。

代码遵循面向对象原则，使用接口进行抽象，并使用枚举表示车辆类型。它包括一个主应用程序类，用于展示车辆的创建和使用。

## 项目结构

- **Vehicle.java**：定义抽象车辆的接口，包含 `drive()` 方法。
- **VehicleFactory.java**：抽象工厂的接口，包含 `createVehicle(VehicleType type)` 方法。
- **VehicleType.java**：表示车辆类型的枚举（CAR、BICYCLE、MOTORCYCLE、UNDEFINED）。
- **BMWFactory.java**：BMW 车辆的具体工厂，支持 CAR 和 MOTORCYCLE。
- **TeslaFactory.java**：Tesla 车辆的具体工厂，支持 CAR 和 BICYCLE。
- **BMWCar.java**：BMW 汽车的具体实现。
- **BMWMotorcycle.java**：BMW 摩托车的具体实现。
- **TeslaCar.java**：Tesla 汽车的具体实现。
- **TeslaBicycle.java**：Tesla 自行车的具体实现。
- **App.java**：主应用程序类，演示工厂的使用并处理不支持的类型，使用异常处理。

所有类均位于包 `com.spike.vehicle.factory` 中。

## UML

(https://www.plantuml.com/plantuml/svg/fPBFQW8n4CRl-nHpN2dT1-YXgAk2K1MiRIdYOHf76yp-8PaLnFhkJRl6DQ6bXJtiOJFVzyitC-aQHirLfg8InGwt1AB84bFA7ILxUfT2KR91mOK-m34240gDWLvPVly1t426CezHRmtSmIDhcM-NgmuSBPUbE5dHroTp9cqv1Cyrz69VQxcdk7Cnmn7V36iKxBoKLvcpBGvbOqrxy-QU-gW_Jb_JXs5uF9ajPlCVAq_JmN0qdWu7Vk4MMBAYIwgpcelwD-w4bJsgYcQRECUiSLcL5xovel6OE50jLtyER-GMSWO9JSXqBiPi8JxowePml6wZ_SbB2wg7Mf1Hs0OMv4fHXw_bFti9A9F2vX47eQWLpFNNDfJZz6MhJAVeQd59yd4VF978BUDNGJrWhnJvu_9AhldmrBKIwhkKhwjCVG80)

## 设计模式说明

此处使用工厂方法模式来：

- 将对象创建与具体类解耦。
- 允许子类（具体工厂）决定实例化哪个类。
- 通过抛出 `IllegalArgumentException` 处理不支持的车辆类型。

这促进了灵活性：要添加新制造商（例如 Ford），只需实现 `VehicleFactory` 并添加具体车辆类。要添加新车辆类型（例如
TRUCK），更新枚举并相应地更新工厂。

## 先决条件

- Java 开发工具包 (JDK) 8 或更高版本。
- Java 编译器（例如 `javac`）和运行时（例如 `java`）。

## 如何编译和运行

1. 克隆或下载项目。
2. 导航到项目目录。
3. 编译 Java 文件：
   ```
   javac com/spike/vehicle/factory/*.java
   ```
4. 运行主应用程序：
   ```
   java com.spike.vehicle.factory.App
   ```

### 预期输出

```
Driving a BMW Car
Driving a BMWMotorcycle
Driving a Tesla Car
Driving a TeslaBicycle
Handled: Unsupported vehicle type: UNDEFINED
```

这演示了从工厂创建车辆并使用异常处理未定义类型。

## 扩展项目

- **添加新工厂**：创建一个实现 `VehicleFactory` 的类，并覆盖 `createVehicle()`。
- **添加新车辆类型**：添加到 `VehicleType` 枚举中，并更新工厂中的 switch 语句。
- **错误处理**：工厂针对不支持的类型抛出异常，并在演示中捕获。

## 作者

- Ayanami
- 日期：2025/10/20

## 许可证

此项目用于教育目的，无许可证。欢迎随意使用和修改。