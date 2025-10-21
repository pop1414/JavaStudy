package com.spike.ui;

/**
 * MacButton 类表示特定于 Mac 操作系统的按钮组件。
 * 它实现了 Button 接口，并提供了一个渲染方法，返回
 * Mac 风格按钮的字符串表示。
 * 此类是抽象工厂模式的一部分，作为 Mac 产品族中的具体产品。*
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class MacButton implements Button {

    @Override
    public String render() {
        return "MacButton";
    }
}
