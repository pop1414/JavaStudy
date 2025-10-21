package com.spike.ui;

/**
 * 工厂模式与抽象工厂模式，工厂模式是抽象工厂模式的退化
 * 抽象工厂模式的产品可以分为二维，分别是产品等级结构与产品族两个维度
 * 产品等级结构，即不同的产品类型，例如手机电脑平板属于不同的产品等级结构
 * 产品族，即某个公司不同产品类型的集合，例如Iphone、Ipad、Mac，属于苹果的产品族
 * <p>
 * 而工厂模式没有产品等级结构这一维，比如A公司的电视，与B公司的电视
 * 但显示生活中一般是较为复杂的场景，用抽象工厂模式更为贴切，因为某个公司大概率不会只有一种产品，大概率会有自己的产品等级结构，这些不同的产品组成该公司的产品族
 *
 * @author Ayanami
 * @date 2025/10/20
 */
public class App {
    public static void main(String[] args) {
        UIFactory macFactory = OperatingSystemUI.FactoryMaker.makeUIFactory(OperatingSystemUI.FactoryMaker.OperatingSystemType.MAC);

        UIFactory windowsFactory = OperatingSystemUI.FactoryMaker.makeUIFactory(OperatingSystemUI.FactoryMaker.OperatingSystemType.WINDOWS);

        System.out.println(macFactory.createScrollbar().render());
        System.out.println(macFactory.createButton().render());

        System.out.println(windowsFactory.createScrollbar().render());
        System.out.println(windowsFactory.createButton().render());

        try {
            UIFactory invalidFactory = OperatingSystemUI.FactoryMaker.makeUIFactory(OperatingSystemUI.FactoryMaker.OperatingSystemType.UNDEFINED);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
