package oopstudy_solid.examples.dynamic_factory.car;

public class ElectricCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a electric car");
    }
}
