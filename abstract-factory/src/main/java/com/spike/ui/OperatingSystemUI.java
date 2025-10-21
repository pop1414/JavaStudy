package com.spike.ui;

/**
 * OperatingSystemUI 类在抽象工厂模式中充当客户端。
 * 它持有 Button 和 Scrollbar 组件的引用，并提供一个静态的
 * FactoryMaker 内部类，根据操作系统类型创建适当的 UIFactory。
 * 此设置允许轻松创建 UI 组件，而无需直接实例化具体类。*
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class OperatingSystemUI {

    private Button button;

    private Scrollbar scrollbar;

    // 内部静态类，无需OperatingSystemUI类，就可以让外部直接使用内部的方法
    // 用来创建不同系统的UI工厂
    public static class FactoryMaker {

        public enum OperatingSystemType {
            WINDOWS,
            MAC,
            UNDEFINED;
        }

        /**
         * 此方法为静态的，也是为了不用创建任何对象示例就可以直接使用
         *
         * @param operatingSystemType
         * @return {@code UIFactory }
         */
        public static UIFactory makeUIFactory(OperatingSystemType operatingSystemType) {
            switch (operatingSystemType) {
                case WINDOWS:
                    return new WindowsUIFactory();
                case MAC:
                    return new MacUIFactory();
                default:
                    // ← 改成抛异常
                    throw new IllegalArgumentException("Unsupported OS type: " + operatingSystemType);
            }
        }
    }
}

