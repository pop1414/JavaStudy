package com.spike;


/**
 * 抽象装饰类，也是抽象组件的子类，持有Component的一个引用，核心是组合一个Component对象（客户端使用一般是具体组件，最基础的核心功能）
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public abstract class DataSourceDecorator implements DataSource {
    protected final DataSource wrapper;

    protected DataSourceDecorator(DataSource wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void write(String data) {
        wrapper.write(data);
    }

    @Override
    public String read() {
        return wrapper.read();
    }
}
