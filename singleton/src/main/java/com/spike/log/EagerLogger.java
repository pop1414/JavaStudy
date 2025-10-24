package com.spike.log;

/**
 * 饿汉式
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class EagerLogger {
    // 饿汉式用final
    private static final EagerLogger LOGGER = new EagerLogger();

    private EagerLogger() {

    }

    public static EagerLogger getInstance() {
        return LOGGER;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
