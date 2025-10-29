package com.spike;

/**
 * 优点：比继承更加灵活，继承是静态的。子类一旦继承，所有子类都有一样的功能（与现实一般不符），而是不同的子类有不同的功能，通过对象组合的方法，把功能分离至每个具体装饰类中
 * 更容易复用功能，还可以叠加功能
 * 简化高层定义，不需要定义所有功能，定义最基本的即可，后面的功能用装饰器添加即可
 * <p>
 * 缺点：一般一个装饰器只实现一个功能，这样就会产生很多细粒度的对象
 * 对于多次装饰的对象，排错较为繁琐
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class App {
    public static void main(String[] args) {
        String data = "Hello Decorator Pattern!";

        DataSource source = new InMemorySource();

        source.write(data);

        // 3) 逐层包装：Shift -> Reverse -> Mod
        //    每一层外再包一层 DebugDecorator 来打印前后值
        DataSource shift = new DebugDecorator("Shift",
                new ShiftCipherDecorator(source, 5));

        DataSource reverse = new DebugDecorator("Reverse",
                new ReverseDecorator(shift));

        DataSource mod = new DebugDecorator("Mod",
                new ModCipherDecorator(reverse, 7));

        // 4) 客户端只面对最外层引用
        DataSource pipe = mod;

        System.out.println("===== START =====");
        System.out.println("原始数据: " + data);
        System.out.println();

        // 写入（会从外到内逐层调用 write）
        pipe.write(data);
        System.out.println();

        // 读取（会从内到外逐层调用 read）
        String result = pipe.read();
        System.out.println();

        System.out.println("读取结果: " + result);
        System.out.println("[一致性] " + (data.equals(result) ? "OK" : "不一致！"));
        System.out.println("=====  END  =====");
    }
}

