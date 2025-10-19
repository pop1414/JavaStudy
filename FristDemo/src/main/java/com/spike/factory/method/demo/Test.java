package com.spike.factory.method.demo;

/**
 * @author Ayanami
 */
public class Test {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int sum = sum(num1, num2);
        System.out.println(sum);
        System.out.println("hello");
    }

    /**
     *
     * @param num1 数1
     * @param num2 数2
     * @return int 返回两数之和
     */
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
