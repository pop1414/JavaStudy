package com.spike.atlas.studio;

/**
 * 代理主题角色
 * 为处于两个不同地址空间对象的访问提供了一种实现机制，可以将一些消耗资源较多的对象和操作移动至性能更好的计算机上
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class RemoteProxy implements Image {
    private Image realImage;
    private final String filename;
    private final String url;

    // 客户端想要的图片与其url
    public RemoteProxy(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("Accessing remote server" + url);
            // 模拟远程加载
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

    @Override
    public void displayFull() {
        if (realImage == null) {
            System.out.println("Accessing remote server" + url);
            realImage = new RealImage(filename);
        }
        realImage.displayFull();
    }
}
