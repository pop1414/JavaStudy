package com.spike.order;


import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 容器组件，孩子既可以是叶节点，也开始容器组件
 *
 * @author Ayanami
 * @date 2025/10/28
 */
public class Combo implements MenuComponent {
    private final String name;
    // 套餐相比于单点优惠多少
    private final int discountPercent;
    // 是否为素数是由孩子决定的，所以无需多出一个成员，用接口方法isVegetarian返回结果即可
    @Getter
    private List<MenuComponent> children = new ArrayList<>();

    public Combo(String name, int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("discount 0~100");
        }
        this.name = name;
        this.discountPercent = discountPercent;
    }

    public Combo addChild(MenuComponent menuComponent) {
        // 防环：禁止把祖先加为子节点
        if (menuComponent == this) {
            throw new IllegalArgumentException("cannot add self");
        }
        if (contains(menuComponent, this)) {
            throw new IllegalArgumentException("cannot add child");
        }
        children.add(menuComponent);
        return this;
    }

    public void removeChild(MenuComponent menuComponent) {
        children.remove(menuComponent);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public BigDecimal price() {
        BigDecimal price = BigDecimal.ZERO;
        for (MenuComponent menuComponent : children) {
            price = price.add(menuComponent.price());
        }
        // 折扣乘子，先保留更多小数避免过早舍入
        BigDecimal factor = BigDecimal.valueOf(100 - discountPercent)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
        return price.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean isVegetarian() {
        for (MenuComponent child : children) {
/*             如果是单品，直接知道是否为素食
             如果是孩子是套餐，则递归调用isVegetarian*/
            if (!child.isVegetarian()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void print(String indent) {
        String title = String.format("%s (-%d%%) 价格: %s", name, discountPercent,
                price().setScale(2, RoundingMode.HALF_UP));
        System.out.println(indent + title);
        for (MenuComponent c : children) {
            c.print(indent + "  ");
        }
    }

    // target是否包含candidate，如果target已经是candidate的父节点，那么candidate就无法将target加入为孩子
    // 注意是静态的
    private static boolean contains(MenuComponent target, MenuComponent candidate) {
        // 如果target不是Combo，说明是Dish，Dish无孩子，肯定不包含candidate，返回false
        if (!(target instanceof Combo)) {
            return false;
        }
        Combo combo = (Combo) target;
        // 如果没有就要遍历
        for (MenuComponent child : combo.children) {
            if (child == candidate || contains(child, candidate)) {
                return true;
            }
        }
        return false;
    }
}
