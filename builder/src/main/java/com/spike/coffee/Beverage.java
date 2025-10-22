package com.spike.coffee;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Product产品类
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class Beverage {
    private final Base base;
    private final List<Addition> additions;
    @Getter
    private final double price;
    private final Size size;


    private Beverage(Builder builder) {
        this.base = builder.base;
        /* 防御性拷贝 + 不可变 (Java 10+)
        this.additions = List.copyOf(b.additions);
         */
        this.additions = builder.additions;
        // 默认size
        this.size = builder.size != null ? builder.size : Size.SMALL;
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        double price = 0;
        price += base.getPrice();
        switch (size) {
            case SMALL:
                price = price * 1.5;
                break;
            case MEDIUM:
                price = price * 2.0;
                break;
            case LARGE:
                price = price * 3.0;
                break;
        }
        for (Addition addition : additions) {
            price += addition.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder size = new StringBuilder();
        switch (this.size) {
            case SMALL:
                size.append(" Small ");
                break;
            case MEDIUM:
                size.append(" Medium ");
                break;
            case LARGE:
                size.append(" Large ");
                break;
        }
        sb.append("This is a").append(size).append("base with").append(this.base.getDescription()).append("adding");
        for (Addition addition : additions) {
            sb.append(addition.getDescription());
        }
        return sb.toString();
    }

    // 内部静态类
    // Beverage的构造函数是private，只有使用Builder类这个内部静态类才可以构造Beverage类
    // 充当的是concreteBuilder（具体建造者）的作用
    // 负责“怎么一步步组装”，在build()中创建Beverage实例
    public static class Builder implements BeverageBuilder {
        private Size size;
        private Base base;
        private final List<Addition> additions = new ArrayList<Addition>();

        /**
         * Constructor.
         */
        @Override
        public BeverageBuilder setSize(Size size) {
            this.size = size;
            return this;
        }

        @Override
        public BeverageBuilder setBase(Base base) {
            this.base = base;
            return this;
        }

        @Override
        public BeverageBuilder addAddition(Addition addition) {
            this.additions.add(addition);
            return this;
        }

        @Override
        public Beverage build() {
            if (base == null) {
                throw new IllegalStateException("Base must be set");
            }
            return new Beverage(this);
        }
    }
}
