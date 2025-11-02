package com.spike.atlas.studio;

/**
 * 真实主题角色，客户端一般不直接使用真实主题，而是使用代理主题角色间接调用真实主题的操作
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class RealImage implements Image {
    private final String filename;

    public RealImage(String fileName) {
        this.filename = fileName;
        loadFromDisk();
    }

    // 模拟真实资源消耗
    private void loadFromDisk() {
        System.out.println("Loading full image from disk: " + filename);
        // 模拟2秒加载延迟
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Full image loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying image from disk: " + filename);
    }

    // 真实主题角色的display是一样的
    @Override
    public void displayFull() {
        display();
    }
}
