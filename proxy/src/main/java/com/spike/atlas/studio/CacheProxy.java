package com.spike.atlas.studio;

import java.util.HashMap;
import java.util.Map;

/**
 * 代理主题角色
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class CacheProxy implements Image {
    private final Image realImage;
    private static final Map<String, Image> CACHE = new HashMap<>();
    private final String filenameAsKey;

    public CacheProxy(Image realImage, String filenameAsKey) {
        this.realImage = realImage;
        this.filenameAsKey = filenameAsKey;
    }

    // Image img1 = new CacheProxy(new RealImage("photo1.jpg"), "photo1.jpg");
    // 客户端是如此调用的
    // 先看看哈希表中有没有，没有就要新创建一个（loadFromDisk()）
    // 若有，返回哈希表中的对象引用，无需loadFromDisk()
    private Image materialize() {
        Image image = CACHE.get(filenameAsKey);
        if (image == null) {
            System.out.println("Cache miss for '" + filenameAsKey + "'. Loading once...");
            CACHE.put(filenameAsKey, realImage);
            image = realImage;
        } else {
            System.out.println("Cache hit for '" + filenameAsKey + "'! Using cached image.");
        }
        return image;
    }

    @Override
    public void display() {
        Image img = materialize();
        img.display();
    }

    @Override
    public void displayFull() {
        Image img = materialize();
        img.displayFull();
    }

    // 可选：清除缓存的工具方法
    public static void clearCache() {
        CACHE.clear();
        System.out.println("Cache cleared.");
    }
}
