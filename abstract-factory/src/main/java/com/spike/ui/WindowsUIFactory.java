package com.spike.ui;

/**
 * WindowsUIFactory 是实现 UIFactory 接口的具体工厂。
 * 它创建特定于 Windows 操作系统的 UI 组件，确保
 * 所有组件（Button 和 Scrollbar）与 Windows 风格一致。
 * 此类通过生产相关产品族来演示抽象工厂模式。*
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class WindowsUIFactory implements UIFactory {
    @Override
    public Scrollbar createScrollbar() {
        return new WindowsScrollbar();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
