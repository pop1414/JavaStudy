package com.spike.atlas.studio;

/**
 * 代理模式演示应用 - 真实调用链
 * 展示代理的组合使用和调用链传递
 * <p>
 * 客户端可以针对抽象主题(Image)进行编程，增加和更换代理类无需修改代码，符合开闭原则
 * 由于客户端和真实主题之间加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢
 * 实现代理模式需要额外的工作，有些代理模式的实现非常复杂
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("代理模式 - 真实调用链演示");
        System.out.println("=".repeat(80));

        // 场景1：完整的代理调用链
        scenario1CompleteProxyChain();

        // 场景2：企业级应用 - 多层代理组合
        scenario1CompleteProxyChain();

        // 场景3：缓存 + 智能引用的组合
        scenario3CacheWithSmartReference();

        System.out.println("\n" + "=".repeat(80));
        System.out.println("所有场景演示完成！");
        System.out.println("=".repeat(80));
    }

    /**
     * 场景1：完整的代理调用链
     * 客户端 -> 防火墙代理 -> 保护代理 -> 缓存代理 -> 虚拟代理 -> 真实对象
     */
    private static void scenario1CompleteProxyChain() {
        System.out.println("\n【场景1：完整的代理调用链】");
        System.out.println("调用链：客户端 -> 防火墙 -> 权限检查 -> 缓存 -> 虚拟代理 -> 真实对象");
        System.out.println("-".repeat(80));

        // 构建代理链（从内到外）
        // 1. 最内层：真实对象
        Image realImage = new RealImage("sensitive_data.jpg");

        // 2. 虚拟代理：延迟加载
        Image virtualProxy = new VirtualProxy("sensitive_data.jpg");

        // 3. 缓存代理：避免重复加载
        Image cacheProxy = new CacheProxy(realImage, "sensitive_data.jpg");

        // 4. 保护代理：权限控制
        Image protectProxy = new ProtectProxy(cacheProxy, "admin");

        // 5. 最外层：防火墙代理
        Image firewallProxy = new FirewallProxy(protectProxy, "sensitive_data.jpg", "192.168.1.10");

        System.out.println("\n>>> 第一次访问（管理员 + 合法IP）：");
        firewallProxy.display();

        System.out.println("\n>>> 第二次访问（缓存命中）：");
        Image firewallProxy2 = new FirewallProxy(
                new ProtectProxy(
                        new CacheProxy(new RealImage("sensitive_data.jpg"), "sensitive_data.jpg"),
                        "admin"
                ),
                "sensitive_data.jpg",
                "192.168.1.10"
        );
        firewallProxy2.display();

        System.out.println("\n>>> 第三次访问（普通用户，权限拒绝）：");
        Image firewallProxy3 = new FirewallProxy(
                new ProtectProxy(
                        new CacheProxy(new RealImage("sensitive_data.jpg"), "sensitive_data.jpg"),
                        "user"
                ),
                "sensitive_data.jpg",
                "192.168.1.10"
        );
        firewallProxy3.display();

        System.out.println("\n>>> 第四次访问（黑名单IP，防火墙拦截）：");
        Image firewallProxy4 = new FirewallProxy(
                new ProtectProxy(
                        new CacheProxy(new RealImage("sensitive_data.jpg"), "sensitive_data.jpg"),
                        "admin"
                ),
                "sensitive_data.jpg",
                "192.168.1.100"
        );
        firewallProxy4.display();
    }

    /**
     * 场景2：企业级应用 - 远程服务访问
     * 客户端 -> 防火墙 -> 缓存 -> 远程代理 -> 真实远程对象
     */
    private static void scenario2EnterpriseApplication() {
        System.out.println("\n\n【场景2：企业级应用 - 远程图片服务】");
        System.out.println("调用链：客户端 -> 防火墙 -> 缓存 -> 远程代理 -> 远程服务器");
        System.out.println("-".repeat(80));

        System.out.println("\n>>> 用户A从合法IP首次请求远程图片：");
        Image remoteImage1 = buildEnterpriseProxy("company_logo.png", "192.168.1.20");
        remoteImage1.display();

        System.out.println("\n>>> 用户B从相同IP再次请求（命中缓存，无需远程加载）：");
        Image remoteImage2 = buildEnterpriseProxy("company_logo.png", "192.168.1.20");
        remoteImage2.display();

        System.out.println("\n>>> 用户C从黑名单IP请求（防火墙拦截）：");
        Image remoteImage3 = buildEnterpriseProxy("company_logo.png", "10.0.0.50");
        remoteImage3.display();

        System.out.println("\n>>> 用户D请求非法文件类型（防火墙拦截）：");
        Image remoteImage4 = buildEnterpriseProxy("virus.exe", "192.168.1.20");
        remoteImage4.display();
    }

    /**
     * 构建企业级代理链的工厂方法
     */
    private static Image buildEnterpriseProxy(String filename, String clientIp) {
        // 从内到外构建
        Image remoteProxy = new RemoteProxy(filename, "https://cdn.company.com/");
        Image cacheProxy = new CacheProxy(remoteProxy, filename);
        Image firewallProxy = new FirewallProxy(cacheProxy, filename, clientIp);
        return firewallProxy;
    }

    /**
     * 场景3：智能引用 + 缓存的组合使用
     * 展示多个客户端共享资源的场景
     */
    private static void scenario3CacheWithSmartReference() {
        System.out.println("\n\n【场景3：多客户端共享资源 - 智能引用 + 缓存】");
        System.out.println("调用链：客户端 -> 缓存代理 -> 智能引用代理 -> 真实对象");
        System.out.println("-".repeat(80));

        // 创建共享资源的智能引用代理
        SmartReferenceProxy smartProxy = new SmartReferenceProxy("shared_document.jpg");

        System.out.println("\n>>> 客户端1：添加引用并使用资源");
        smartProxy.addReference();
        Image client1View = new CacheProxy(smartProxy, "shared_document.jpg");
        client1View.display();

        System.out.println("\n>>> 客户端2：添加引用并使用资源（引用计数+1）");
        smartProxy.addReference();
        Image client2View = new CacheProxy(smartProxy, "shared_document.jpg");
        client2View.display();
        System.out.println("当前引用计数: " + smartProxy.getReferenceCount());

        System.out.println("\n>>> 客户端3：添加引用（引用计数+1）");
        smartProxy.addReference();
        System.out.println("当前引用计数: " + smartProxy.getReferenceCount());

        System.out.println("\n>>> 客户端1：完成使用，释放引用");
        smartProxy.removeReference();

        System.out.println("\n>>> 客户端4：通过缓存快速访问（缓存命中）");
        Image client4View = new CacheProxy(smartProxy, "shared_document.jpg");
        client4View.display();

        System.out.println("\n>>> 客户端2：释放引用");
        smartProxy.removeReference();

        System.out.println("\n>>> 客户端3：释放最后一个引用（触发资源释放）");
        smartProxy.removeReference();
        System.out.println("当前引用计数: " + smartProxy.getReferenceCount());

        System.out.println("\n>>> 清除缓存：");
        CacheProxy.clearCache();

        System.out.println("\n>>> 客户端5：资源已释放且缓存已清空，尝试访问");
        Image client5View = new CacheProxy(smartProxy, "shared_document.jpg");
        client5View.display();

        System.out.println("\n>>> 演示完整的资源重新获取流程：");
        System.out.println("1. 添加新引用");
        smartProxy.addReference();
        System.out.println("2. 通过代理访问");
        Image client6View = new CacheProxy(smartProxy, "shared_document.jpg");
        client6View.display();
        System.out.println("3. 释放引用");
        smartProxy.removeReference();
    }

    /**
     * 额外演示：组合模式的灵活性
     */
    @SuppressWarnings("unused")
    private static void demonstrateFlexibility() {
        System.out.println("\n\n【额外演示：代理组合的灵活性】");
        System.out.println("-".repeat(80));

        // 可以根据需求灵活组合不同的代理
        String filename = "report.png";

        // 组合1：简单的防火墙 + 缓存
        Image combo1 = new FirewallProxy(
                new CacheProxy(new RealImage(filename), filename),
                filename,
                "192.168.1.30"
        );

        // 组合2：防火墙 + 权限 + 虚拟代理
        Image combo2 = new FirewallProxy(
                new ProtectProxy(
                        new VirtualProxy(filename),
                        "admin"
                ),
                filename,
                "192.168.1.30"
        );

        // 组合3：完整的企业级代理链
        Image combo3 = new FirewallProxy(
                new ProtectProxy(
                        new CacheProxy(
                                new RemoteProxy(filename, "https://api.example.com/"),
                                filename
                        ),
                        "admin"
                ),
                filename,
                "192.168.1.30"
        );

        System.out.println("✓ 代理可以根据业务需求灵活组合");
        System.out.println("✓ 每个代理专注于单一职责");
        System.out.println("✓ 调用链透明传递，客户端无感知");
    }
}