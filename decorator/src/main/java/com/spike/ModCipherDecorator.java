package com.spike;

/**
 * 具体装饰类，重写方法
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class ModCipherDecorator extends DataSourceDecorator {
    private final int modBase;

    public ModCipherDecorator(DataSource wrapper, int modBase) {
        super(wrapper);
        this.modBase = modBase;
    }

    @Override
    public void write(String data) {
        super.write(jitter(data, modBase));
    }

    @Override
    public String read() {
        String raw = super.read();
        return jitter(raw, -modBase);
    }

    private String jitter(String s, int dir) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            int delta = (c % modBase) * dir;
            sb.append((char) (c + delta));
        }
        return sb.toString();
    }
}
