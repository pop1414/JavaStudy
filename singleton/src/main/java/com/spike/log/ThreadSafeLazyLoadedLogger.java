package com.spike.log;

/**
 * 方法级线程安全
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class ThreadSafeLazyLoadedLogger {
    private static ThreadSafeLazyLoadedLogger INSTANCE;

    private ThreadSafeLazyLoadedLogger() {

    }


    public static synchronized ThreadSafeLazyLoadedLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeLazyLoadedLogger();
        }
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
