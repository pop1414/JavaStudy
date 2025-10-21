package com.spike.ui;

/**
 * UIFactory 接口定义了用于创建 UI 组件的抽象工厂。
 * 它提供了创建 Scrollbar 和 Button 对象的方法，确保
 * 创建的组件属于同一产品族（例如，全 Mac 或全 Windows）。
 * 这是抽象工厂设计模式中的核心接口。*
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public interface UIFactory {

    // 不同的产品是不同的产品等级结构，而不同的公司的不同产品集合属于是产品族
    // Button与Scrollbar属于是不同的产品等级结构，而Windows的B与S是win的产品族，Mac同理
    public abstract Scrollbar createScrollbar();

    public abstract Button createButton();
}
