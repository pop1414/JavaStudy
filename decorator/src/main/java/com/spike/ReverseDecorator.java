package com.spike;

/**
 * 具体装饰类，重写方法
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class ReverseDecorator extends DataSourceDecorator {

    public ReverseDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void write(String data) {
        // 使用父类的方法，参数为处理后的数据
        super.write(new StringBuffer(data).reverse().toString());
    }

    @Override
    public String read() {
        // 读出生数据
        String raw = super.read();
        // 再做处理返回
        return new StringBuffer(raw).reverse().toString();
    }
}
