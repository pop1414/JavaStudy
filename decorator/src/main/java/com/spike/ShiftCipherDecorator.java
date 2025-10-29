package com.spike;

import lombok.Getter;
import lombok.Setter;

/**
 * 具体装饰类，重写方法
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class ShiftCipherDecorator extends DataSourceDecorator {
    @Getter
    @Setter
    // 半透明方法，客户端可以感知装饰器的存在（可以获取shift);
    // 透明方法则不可以暴露多余的方法，在构造方法时直接注入
    private int shift;

    public ShiftCipherDecorator(DataSource wrapper, int shift) {
        super(wrapper);
        this.shift = shift;
    }

    @Override
    public void write(String data) {
        super.write(encode(data, shift));
    }

    @Override
    public String read() {
        String raw = super.read();
        return decode(raw, shift);
    }

    private static String encode(String s, int k) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + k + 26) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + k + 26) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String decode(String s, int k) {
        return encode(s, -k);
    }
}
