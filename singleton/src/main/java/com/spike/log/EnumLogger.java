package com.spike.log;

/**
 * 枚举式
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public enum EnumLogger {
    INSTANCE;

    @Override
    public String toString() {
        return "EnumLogger";
    }

    public void log(String message) {
        System.out.println(message);
    }
}
