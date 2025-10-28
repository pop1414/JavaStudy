package com.spike.order;

import java.math.BigDecimal;

/**
 * 抽象组件，为叶子组件与容器组件声明接口，包含了所有子类共有行为的声明:name(),  price(), print(), isVegetarian();
 * 还定义了访问及管理子组件的方法，如add(), remove(), get() （此样例用的是安全组合设计模式，所有具体的访问及管理子组件的方法，只写在了容器组件中
 * <p>
 * 组合设计模式的主要思想就体现在这，把容器与叶子统一，client使用的时候，就无需思考是哪一种组件
 *
 * @author Ayanami
 * @date 2025/10/28
 */
public interface MenuComponent {
    String name();

    BigDecimal price();

    void print(String indent);

    boolean isVegetarian();


}
