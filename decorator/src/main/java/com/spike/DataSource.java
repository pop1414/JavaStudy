package com.spike;

/**
 * 抽象组件是所有组件（包括装饰器）的父类，声明了组件对象的业务接口（read(), write()）
 * 让客户端以一致的方法操作“未被装饰的对象”与“被装饰的对象”
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public interface DataSource {
    void write(String data);

    String read();
}
