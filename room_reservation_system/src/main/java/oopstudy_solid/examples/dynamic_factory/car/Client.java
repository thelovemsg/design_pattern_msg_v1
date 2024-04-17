package oopstudy_solid.examples.dynamic_factory.car;

public class Client {
    public static void main(String[] args) {
        CarFactory.registerCar("electric", ElectricCar::new);
        Car electric = CarFactory.getCar("electric");
        electric.drive();
    }
}
