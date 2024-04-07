package oopstudy_solid.examples.decorator;

public class Cafe {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        Beverage mochaBeverage = new Mocha(beverage);

        System.out.println("mochaBeverage.cost() = " + mochaBeverage.cost());
    }
}
