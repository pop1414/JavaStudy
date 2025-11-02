package com.spike.atlas.studio;

/**
 * 抽象主题角色，声明了真实主题与代理主题的共同接口，这样依一来任何使用真实主题的地方都可以使用代理主题
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public interface Image {
    // 显示缩略图或占位符（如果未加载）
    void display();

    // 请求显示原图（触发加载)
    void displayFull();
}
