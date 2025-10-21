package com.spike.ui;

/**
 * WindowsScrollbar 类表示特定于 Windows 操作系统的滚动条组件。
 * 它实现了 Scrollbar 接口，并提供了一个渲染方法，返回
 * Windows 风格滚动条的字符串表示。
 * 此类是抽象工厂模式的一部分，作为 Windows 产品族中的具体产品。*
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class WindowsScrollbar implements Scrollbar {

    @Override
    public String render() {
        return "WindowsScrollbar";
    }
}
