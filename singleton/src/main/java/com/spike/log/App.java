package com.spike.log;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class App {
    public static void main(String[] args) {
        LazyLogger logger = LazyLogger.getInstance();
        logger.log("Hello Lazy");

        EagerLogger eagerLogger = EagerLogger.getInstance();
        eagerLogger.log("Hello Eager");

        EnumLogger enumLogger1 = EnumLogger.INSTANCE;
        EnumLogger enumLogger2 = EnumLogger.INSTANCE;
        System.out.println("实例是否相同？ " + (enumLogger2 == enumLogger1));
        enumLogger1.log("Hello World1");
        enumLogger2.log("Hello World2");

        ThreadSafeLazyLoadedLogger lazy1 = ThreadSafeLazyLoadedLogger.getInstance();
        ThreadSafeLazyLoadedLogger lazy2 = ThreadSafeLazyLoadedLogger.getInstance();
        System.out.println("实例是否相同？ " + (lazy1 == lazy2));
    }

}
