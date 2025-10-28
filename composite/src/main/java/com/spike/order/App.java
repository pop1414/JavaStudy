package com.spike.order;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 统一叶子对象与容器对象
 * 优点：简化了客户端调用；更容易扩展，新添加的组件很容易就与已有的结构工作，因为容器组价(Combo)的方法参数都是抽象组件(MenuComponent)
 * <p>
 * 缺点：很难限制容器，例如要强制某个套餐只能用Dish，就很难实现，因为接口是统一的(MenuComponent)，需要修改旧代码，违反了开闭原则，只能改动addChild方法加运行时检查。
 *
 * @author Ayanami
 * @date 2025/10/28
 */
public class App {
    public static void main(String[] args) {
        // 单品（名称/分/是否素食）
        MenuComponent beefBurger = new Dish("牛肉汉堡", 2800, false);
        MenuComponent fries = new Dish("薯条", 1200, true);
        MenuComponent cola = new Dish("可乐", 600, true);
        MenuComponent friedChick = new Dish("炸鸡", 2400, false);
        MenuComponent salad = new Dish("沙拉", 1800, true);

        // 单人套餐A = [汉堡, 薯条, 可乐]，-15%
        Combo singleA = new Combo("单人套餐A", 15).addChild(beefBurger).addChild(fries).addChild(cola);

        // 情侣套餐 = [单人套餐A, 炸鸡, 沙拉]，-10%
        Combo couple = new Combo("情侣套餐", 10).addChild(singleA).addChild(friedChick).addChild(salad);

        // 全素套餐 = [薯条，沙拉，可乐], -5%
        Combo trueVegetarian = new Combo("全素套餐", 5).addChild(fries).addChild(cola).addChild(salad);

        // 打印与断言
        singleA.print("");
        couple.print("");
        trueVegetarian.print("");

        if (!eq(singleA.price(), "39.10")) {
            throw new AssertionError("单人套餐A价格错误");
        }
        if (!eq(couple.price(), "72.99")) {
            throw new AssertionError("单人套餐A价格错误");
        }
        if (!eq(trueVegetarian.price(), "34.20")) {
            throw new AssertionError("单人套餐A价格错误");
        }

        System.out.println(singleA.isVegetarian());
        System.out.println(couple.isVegetarian());
        System.out.println(trueVegetarian.isVegetarian());


    }

    private static boolean eq(BigDecimal actual, String expected2dp) {
        return actual.setScale(2, RoundingMode.HALF_UP)
                .toPlainString().equals(expected2dp);
    }

}
