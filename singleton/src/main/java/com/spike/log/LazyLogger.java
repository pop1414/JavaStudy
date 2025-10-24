package com.spike.log;

/**
 * 懒汉式
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class LazyLogger {
    private static LazyLogger logger = null;

    private LazyLogger() {
    }

    public static LazyLogger getInstance() {
        if (logger == null) {
            logger = new LazyLogger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
