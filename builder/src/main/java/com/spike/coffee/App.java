package com.spike.coffee;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/22
 */
public class App {
    public static void main(String[] args) {
        BeverageDirector director = new BeverageDirector();

        Beverage latte = director.makeLatte(new Beverage.Builder());
        System.out.println("Latte -> " + latte + ", price=" + latte.getPrice());


        Beverage mochaL = director.makeMochaLarge(new Beverage.Builder());
        System.out.println("Mocha(L) -> " + mochaL + ", price=" + mochaL.getPrice());

        Beverage sweetTeaS = director.makeSweetTeaSmall(new Beverage.Builder());
        System.out.println("Sweet Tea(S) -> " + sweetTeaS + ", price=" + sweetTeaS.getPrice());
    }
}
