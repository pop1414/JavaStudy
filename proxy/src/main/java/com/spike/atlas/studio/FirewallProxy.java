package com.spike.atlas.studio;

import java.util.HashSet;
import java.util.Set;

/**
 * 代理主题角色*
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class FirewallProxy implements Image {
    private final Image realImage;
    private final String filename;
    private final String clientIp;

    // 黑名单
    private static final Set<String> BLACKLIST = new HashSet<>();
    // 白名单
    private static final Set<String> WHITELIST = new HashSet<>();

    static {
        // 初始化黑名单
        BLACKLIST.add("192.168.1.100");
        BLACKLIST.add("10.0.0.50");

        // 初始化允许的文件类型
        WHITELIST.add(".jpg");
        WHITELIST.add(".png");
        WHITELIST.add(".gif");
    }

    public FirewallProxy(Image realImage, String filename, String clientIp) {
        this.realImage = realImage;
        this.filename = filename;
        this.clientIp = clientIp;
    }

    private boolean isRequestAllowed() {
        // 检查IP黑名单
        if (BLACKLIST.contains(clientIp)) {
            System.out.println("❌ Firewall blocked: IP " + clientIp + " is blacklisted.");
            return false;
        }

        boolean validExtension = false;
        for (String ext : WHITELIST) {
            if (filename.toLowerCase().endsWith(ext)) {
                validExtension = true;
                break;
            }
        }

        if (!validExtension) {
            System.out.println("❌ Firewall blocked: File type not allowed for " + filename);
            return false;
        }

        // 检查文件名中的危险字符
        if (filename.contains("..") || filename.contains("//")) {
            System.out.println("❌ Firewall blocked: Suspicious file path detected.");
            return false;
        }

        System.out.println("✓ Firewall check passed for IP: " + clientIp);
        return true;
    }

    @Override
    public void display() {
        if (isRequestAllowed()) {
            realImage.display();
        } else {
            System.out.println("Access denied by firewall.");
        }
    }

    @Override
    public void displayFull() {
        if (isRequestAllowed()) {
            realImage.displayFull();
        } else {
            System.out.println("Access denied by firewall.");
        }
    }

    // 管理黑名单的工具方法
    public static void addToBlacklist(String ip) {
        BLACKLIST.add(ip);
        System.out.println("Added " + ip + " to blacklist.");
    }

    public static void removeFromBlacklist(String ip) {
        BLACKLIST.remove(ip);
        System.out.println("Removed " + ip + " from blacklist.");
    }
}
