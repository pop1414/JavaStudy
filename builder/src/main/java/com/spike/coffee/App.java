package com.spike.coffee;

/**
 * 优点：每一个具体Builder相互独立，使用不同的Builder就可以得到不同的产品对象（例如基本款与折扣款）
 * 产品本身与产品制造过程解耦
 * 可以更加精细地控制产品制造过程（例如addition可以多选，或不选）
 * 符合开闭原则，通过实现抽象制造者的接口，增加新的Builder
 * 缺点：只适用于不同产品之间具有许多共同点（如本例，饮品都有size，base，addition（可选）），若产品的内部变化较为复杂，则会使得此方法系统臃肿
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
