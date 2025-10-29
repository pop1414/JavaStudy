package com.spike;


/**
 * 具体装饰类
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class DebugDecorator extends DataSourceDecorator {
    private final String name;

    public DebugDecorator(String name, DataSource wrapper) {
        super(wrapper);
        this.name = name;
    }

    @Override
    public void write(String data) {
        System.out.println("[" + name + "][write]  in:  " + data);
        super.write(data);
        System.out.println("[" + name + "][write]  out: " + wrapper.read());
    }

    @Override
    public String read() {
        String before = wrapper.read();
        System.out.println("[" + name + "][read ]  in:  " + before);
        String result = super.read();
        System.out.println("[" + name + "][read ]  out: " + result);
        return result;
    }
}

