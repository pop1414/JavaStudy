package com.spike.atlas.studio;

/**
 * 代理主题角色
 * 控制对一个对象的访问权限，不同的角色有不同的权限
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class ProtectProxy implements Image {
    private final Image realImage;
    private final String userRole;

    public ProtectProxy(Image realImage, String userRole) {
        this.realImage = realImage;
        this.userRole = userRole;
    }

    @Override
    public void display() {
        if ("admin".equals(userRole)) {
            realImage.display();
        } else {
            System.out.println("Access denied: Insufficient permissions for display.");
        }
    }

    @Override
    public void displayFull() {
        if ("admin".equals(userRole)) {
            realImage.displayFull();
        } else {
            System.out.println("Access denied: Insufficient permissions for full display.");
        }
    }
}
