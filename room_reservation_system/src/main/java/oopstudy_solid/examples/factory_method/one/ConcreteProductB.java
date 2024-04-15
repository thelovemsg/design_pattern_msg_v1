package oopstudy_solid.examples.factory_method.one;

public class ConcreteProductB implements IProduct{
    @Override
    public void setting() {
        System.out.println("Concrete Product B with IProduct");
    }
}
