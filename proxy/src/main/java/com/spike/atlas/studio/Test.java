package com.spike.atlas.studio;


/**
 * 代理模式演示应用
 * 展示7种代理模式的使用场景
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("代理模式演示程序");
        System.out.println("=".repeat(60));

        // 1. 虚拟代理 - 延迟加载
        demonstrateVirtualProxy();

        // 2. 远程代理 - 模拟远程访问
        demonstrateRemoteProxy();

        // 3. 保护代理 - 权限控制
        demonstrateProtectProxy();

        // 4. 防火墙代理 - 安全过滤
        demonstrateFirewallProxy();

        // 5. 缓存代理 - 提高性能
        demonstrateCacheProxy();

        // 6. 智能引用代理 - 引用计数
        demonstrateSmartReferenceProxy();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("所有演示完成！");
        System.out.println("=".repeat(60));
    }

    /**
     * 1. 虚拟代理演示 - 延迟加载大对象
     */
    private static void demonstrateVirtualProxy() {
        System.out.println("\n【1. 虚拟代理 - Virtual Proxy】");
        System.out.println("场景：延迟加载大图片，先显示缩略图");
        System.out.println("-".repeat(60));

        Image image = new VirtualProxy("landscape.jpg");

        System.out.println("\n>>> 第一次调用 display() - 只显示缩略图");
        image.display();

        System.out.println("\n>>> 调用 displayFull() - 触发后台加载");
        image.displayFull();

        // 等待后台加载完成
        sleep(3000);

        System.out.println("\n>>> 再次调用 display() - 已加载完成");
        image.display();
    }

    /**
     * 2. 远程代理演示 - 访问远程对象
     */
    private static void demonstrateRemoteProxy() {
        System.out.println("\n\n【2. 远程代理 - Remote Proxy】");
        System.out.println("场景：访问远程服务器上的图片");
        System.out.println("-".repeat(60));

        Image remoteImage = new RemoteProxy("avatar.png", "https://cdn.example.com/images/");

        System.out.println("\n>>> 第一次访问 - 从远程加载");
        remoteImage.display();

        System.out.println("\n>>> 第二次访问 - 使用已加载的对象");
        remoteImage.displayFull();
    }

    /**
     * 3. 保护代理演示 - 权限控制
     */
    private static void demonstrateProtectProxy() {
        System.out.println("\n\n【3. 保护代理 - Protection Proxy】");
        System.out.println("场景：基于角色的访问控制");
        System.out.println("-".repeat(60));

        Image realImage = new RealImage("confidential.jpg");

        System.out.println("\n>>> 管理员访问：");
        Image adminProxy = new ProtectProxy(realImage, "admin");
        adminProxy.display();

        System.out.println("\n>>> 普通用户访问：");
        Image userProxy = new ProtectProxy(realImage, "user");
        userProxy.display();
        userProxy.displayFull();
    }

    /**
     * 4. 防火墙代理演示 - 安全过滤
     */
    private static void demonstrateFirewallProxy() {
        System.out.println("\n\n【4. 防火墙代理 - Firewall Proxy】");
        System.out.println("场景：IP黑名单和文件类型白名单");
        System.out.println("-".repeat(60));

        Image realImage = new RealImage("photo.jpg");

        System.out.println("\n>>> 合法IP访问合法文件：");
        Image safeProxy = new FirewallProxy(realImage, "photo.jpg", "192.168.1.10");
        safeProxy.display();

        System.out.println("\n>>> 黑名单IP尝试访问：");
        Image blockedIpProxy = new FirewallProxy(realImage, "photo.jpg", "192.168.1.100");
        blockedIpProxy.display();

        System.out.println("\n>>> 尝试访问非法文件类型：");
        Image blockedFileProxy = new FirewallProxy(realImage, "malware.exe", "192.168.1.10");
        blockedFileProxy.display();

        System.out.println("\n>>> 尝试路径遍历攻击：");
        Image pathTraversalProxy = new FirewallProxy(realImage, "../etc/passwd", "192.168.1.10");
        pathTraversalProxy.display();
    }

    /**
     * 5. 缓存代理演示 - 提高性能
     */
    private static void demonstrateCacheProxy() {
        System.out.println("\n\n【5. 缓存代理 - Cache Proxy】");
        System.out.println("场景：缓存已加载的图片，避免重复加载");
        System.out.println("-".repeat(60));

        System.out.println("\n>>> 第一次访问 photo1.jpg - 缓存未命中");
        Image proxy1 = new CacheProxy(new RealImage("photo1.jpg"), "photo1.jpg");
        proxy1.display();

        System.out.println("\n>>> 第二次访问 photo1.jpg - 缓存命中");
        Image proxy2 = new CacheProxy(new RealImage("photo1.jpg"), "photo1.jpg");
        proxy2.display();

        System.out.println("\n>>> 访问不同的图片 photo2.jpg");
        Image proxy3 = new CacheProxy(new RealImage("photo2.jpg"), "photo2.jpg");
        proxy3.display();

        System.out.println("\n>>> 清除缓存");
        CacheProxy.clearCache();

        System.out.println("\n>>> 清除后再次访问 photo1.jpg - 再次未命中");
        Image proxy4 = new CacheProxy(new RealImage("photo1.jpg"), "photo1.jpg");
        proxy4.display();
    }

    /**
     * 6. 智能引用代理演示 - 引用计数和资源管理
     */
    private static void demonstrateSmartReferenceProxy() {
        System.out.println("\n\n【6. 智能引用代理 - Smart Reference Proxy】");
        System.out.println("场景：引用计数，自动管理资源生命周期");
        System.out.println("-".repeat(60));

        SmartReferenceProxy smartProxy = new SmartReferenceProxy("shared_resource.jpg");

        System.out.println("\n>>> 尝试在添加引用前访问：");
        smartProxy.display();

        System.out.println("\n>>> 第一个客户端添加引用（触发加载）：");
        smartProxy.addReference();
        smartProxy.display();

        System.out.println("\n>>> 第二个客户端添加引用：");
        smartProxy.addReference();
        System.out.println("当前引用计数: " + smartProxy.getReferenceCount());

        System.out.println("\n>>> 第三个客户端添加引用：");
        smartProxy.addReference();
        System.out.println("当前引用计数: " + smartProxy.getReferenceCount());

        System.out.println("\n>>> 第一个客户端释放引用：");
        smartProxy.removeReference();
        smartProxy.display();

        System.out.println("\n>>> 第二个客户端释放引用：");
        smartProxy.removeReference();

        System.out.println("\n>>> 最后一个客户端释放引用（自动释放资源）：");
        smartProxy.removeReference();

        System.out.println("\n>>> 资源释放后尝试访问：");
        smartProxy.display();
    }

    /**
     * 工具方法：线程休眠
     */
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
