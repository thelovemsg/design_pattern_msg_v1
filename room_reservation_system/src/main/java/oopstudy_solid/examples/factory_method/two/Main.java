package oopstudy_solid.examples.factory_method.two;

public class Main {
    public static void main(String[] args) {
        Ship containerShip = new ContainerShipFactory().orderShip("www.naver.com");
        System.out.println(containerShip);

        Ship oilTankShip = new OilTankerShipFactory().orderShip("www.google.com");
        System.out.println(oilTankShip);

    }
}
