package com.spike.coffee;

/**
 * Builder抽象建造者类
 * 规定了构建步骤的抽象接口：size(...) / setBase(...) / addAddition(...) / build()
 * Director指挥者类只依赖这个接口，从而与具体实现解耦
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public interface BeverageBuilder {

    BeverageBuilder setSize(Size size);

    BeverageBuilder setBase(Base base);

    BeverageBuilder addAddition(Addition addition);

    Beverage build();
}

