package com.spike.atlas.studio;

/**
 * 代理主题角色
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class VirtualProxy implements Image {
    private Image realImage;
    private final String filename;
    private boolean loading = false;
    private boolean loaded = false;

    public VirtualProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (loaded && realImage != null) {
            realImage.display();
        } else {
            // 先显示小对象
            System.out.println("Displaying thumbnail placeholder for: " + filename);


            if (!loading) {
                System.out.println("Full image not loaded yet. Call displayFull() to load.");
            } else {
                System.out.println("Loading in progress...");
            }
        }
    }

    @Override
    public void displayFull() {
        if (loaded && realImage != null) {
            realImage.displayFull();
        } else if (!loading) {
            loading = true;
            System.out.println("Starting background loading of full image: " + filename);
            // 后台线程加载，显示加载过程
            new Thread(() ->
            {
                System.out.println("Loading full image... Please wait.");  // 显示加载过程
                realImage = new RealImage(filename);  // 加载真实图像
                loaded = true;
                loading = false;
                System.out.println("Loading complete. Now displaying full image.");
                realImage.displayFull();
            }).start();
        } else {
            System.out.println("Loading already in progress...");
        }
    }
}
