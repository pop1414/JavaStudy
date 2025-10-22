package com.spike.coffee;

/**
 * 指挥者类负责安排复杂对象的建造次序
 * 其与抽象建造者（BeverageBuilder）之间存在关联关系，因此可以无缝搭配任何ConcreteBuilder（例如折扣版），实现可替换
 * 只关心“建造次序/配方”
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public final class BeverageDirector {
    // 示例配方：拿铁 = Espresso + Milk，默认 MEDIUM
    public Beverage makeLatte(BeverageBuilder builder) {
        return builder
                .setBase(new Espresso())
                .addAddition(new Milk())
                .setSize(Size.MEDIUM)
                .build();
    }

    // 示例配方：摩卡大杯 = Espresso + Chocolate + Milk，LARGE
    public Beverage makeMochaLarge(BeverageBuilder builder) {
        return builder
                .setBase(new Espresso())
                .addAddition(new Chocolate())
                .addAddition(new Milk())
                .setSize(Size.LARGE)
                .build();
    }

    // 再给一个清爽茶：Small Tea + Sugar
    public Beverage makeSweetTeaSmall(BeverageBuilder builder) {
        return builder
                .setBase(new Tea())
                .addAddition(new Sugar())
                .setSize(Size.SMALL)
                .build();
    }
}
