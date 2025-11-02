package com.spike.atlas.studio;

import lombok.Getter;

/**
 * 代理主题角色*
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class SmartReferenceProxy implements Image {
    private Image realImage;
    private final String filename;
    @Getter
    private int referenceCount = 0;
    private boolean loaded = false;

    public SmartReferenceProxy(String filename) {
        this.filename = filename;
    }

    public void addReference() {
        referenceCount++;
        System.out.println("Reference added for '" + filename + "'. Count: " + referenceCount);

        // 第一次引用时才加载
        if (referenceCount == 1 && !loaded) {
            System.out.println("First reference - loading image...");
            realImage = new RealImage(filename);
            loaded = true;
        }
    }

    public void removeReference() {
        if (referenceCount > 0) {
            referenceCount--;
            System.out.println("Reference removed for '" + filename + "'. Count: " + referenceCount);


            // 引用计数归零时自动释放资源
            if (referenceCount == 0) {
                System.out.println("No more references - releasing resource for: " + filename);
                realImage = null;
                loaded = false;
            }
        }
    }

    @Override
    public void display() {
        if (loaded && realImage != null) {
            realImage.display();
        } else {
            System.out.println("Image not loaded. Call addReference() first.");
        }
    }

    @Override
    public void displayFull() {
        if (loaded && realImage != null) {
            realImage.displayFull();
        } else {
            System.out.println("Image not loaded. Call addReference() first.");
        }
    }
}
