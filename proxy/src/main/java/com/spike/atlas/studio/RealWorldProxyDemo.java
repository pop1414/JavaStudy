package com.spike.atlas.studio;


/**
 * 现实世界场景演示：为什么虚拟代理和缓存代理容易混淆
 * 如果是单独使用虚拟代理，是不是每一个客户端都体验一次延迟加载，
 * 如果是单独使用缓存代理，只有第一个用户需要创建新的对象，之后的人调用缓存就行了，
 * 而容易搞混的原因是不是，现实生活中这两种代理一般是同时存在的
 *
 * @author Ayanami
 * @date 2025/11/02
 */
public class RealWorldProxyDemo {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("现实世界场景：理解为什么两种代理容易混淆");
        System.out.println("=".repeat(80));

        scenario1_OnlyVirtual();
        scenario2_OnlyCache();
        scenario3_RealWorld();
    }

    /**
     * 场景1：只用虚拟代理（不现实的场景）
     * 每个用户都要体验一次延迟加载
     */
    private static void scenario1_OnlyVirtual() {
        System.out.println("\n【场景1：只用虚拟代理 - 不现实的做法】");
        System.out.println("比如：一个网站的 logo 图片");
        System.out.println("-".repeat(80));

        System.out.println("\n>>> 用户Alice打开网站首页");
        VirtualProxy aliceLogo = new VirtualProxy("logo.png");
        aliceLogo.display();  // 显示缩略图
        System.out.println("Alice点击查看完整logo...");
        aliceLogo.displayFull();  // 触发加载，等待2秒

        System.out.println("\n>>> 用户Bob打开网站首页");
        VirtualProxy bobLogo = new VirtualProxy("logo.png");
        bobLogo.display();  // 显示缩略图
        System.out.println("Bob点击查看完整logo...");
        bobLogo.displayFull();  // 又要加载2秒！

        System.out.println("\n>>> 用户Charlie打开网站首页");
        VirtualProxy charlieLogo = new VirtualProxy("logo.png");
        charlieLogo.display();  // 显示缩略图
        System.out.println("Charlie点击查看完整logo...");
        charlieLogo.displayFull();  // 又要加载2秒！

        System.out.println("\n❌ 问题：同一个logo，每个用户都要等2秒加载！");
        System.out.println("   这在现实中是不可接受的，服务器也会被重复请求压垮！");
    }

    /**
     * 场景2：只用缓存代理（缺少按需加载）
     * 第一个用户等，后面的用户不等
     */
    private static void scenario2_OnlyCache() {
        System.out.println("\n\n【场景2：只用缓存代理 - 缺少按需加载】");
        System.out.println("比如：网站启动时预加载所有图片");
        System.out.println("-".repeat(80));

        CacheProxy.clearCache();

        System.out.println("\n>>> 用户Alice访问首页（logo会立即加载）");
        CacheProxy aliceLogo = new CacheProxy(
                new RealImage("logo.png"),
                "logo.png"
        );
        aliceLogo.display();  // 第一次访问，缓存未命中，等待2秒

        System.out.println("\n>>> 用户Bob访问首页");
        CacheProxy bobLogo = new CacheProxy(
                new RealImage("logo.png"),
                "logo.png"
        );
        bobLogo.display();  // 缓存命中，瞬间显示！

        System.out.println("\n>>> 用户Charlie访问首页");
        CacheProxy charlieLogo = new CacheProxy(
                new RealImage("logo.png"),
                "logo.png"
        );
        charlieLogo.display();  // 缓存命中，瞬间显示！

        System.out.println("\n⚠️  问题：虽然后面的用户很快，但缺少延迟加载机制");
        System.out.println("   如果页面有100张图片，用户访问时会一次性加载所有");
        System.out.println("   即使用户只看了第一张图片就离开了");
    }

    /**
     * 场景3：现实世界的做法 - 虚拟代理 + 缓存代理
     * 这就是为什么容易混淆：它们总是一起出现！
     */
    private static void scenario3_RealWorld() {
        System.out.println("\n\n【场景3：现实世界的做法 - 组合使用】");
        System.out.println("比如：淘宝商品详情页的图片");
        System.out.println("-".repeat(80));

        CacheProxy.clearCache();

        System.out.println("\n>>> 用户Alice浏览商品（页面显示缩略图，未加载大图）");
        VirtualProxy virtual1 = new VirtualProxy("product_detail.jpg");
        CacheProxy alice = new CacheProxy(virtual1, "product_detail.jpg");
        alice.display();  // 只显示缩略图，不加载大图

        System.out.println("\nAlice向下滚动页面，触发大图加载...");
        alice.displayFull();  // 延迟加载：等待2秒，然后加入缓存

        System.out.println("\n>>> 用户Bob浏览同一个商品");
        VirtualProxy virtual2 = new VirtualProxy("product_detail.jpg");
        CacheProxy bob = new CacheProxy(virtual2, "product_detail.jpg");
        bob.display();  // 缓存命中！瞬间显示

        System.out.println("\nBob向下滚动...");
        bob.displayFull();  // 缓存命中！无需等待

        System.out.println("\n>>> 用户Charlie浏览同一个商品");
        VirtualProxy virtual3 = new VirtualProxy("product_detail.jpg");
        CacheProxy charlie = new CacheProxy(virtual3, "product_detail.jpg");
        charlie.displayFull();  // 缓存命中！秒开

        System.out.println("\n✅ 完美解决方案：");
        System.out.println("   1. 虚拟代理：用户不滚动就不加载大图（按需加载）");
        System.out.println("   2. 缓存代理：加载一次后，其他用户直接用（共享复用）");
        System.out.println("   3. Alice 等了2秒，但Bob和Charlie都是秒开");
        System.out.println("   4. 如果用户没滚动到大图位置，根本不会加载（节省带宽）");
    }
}