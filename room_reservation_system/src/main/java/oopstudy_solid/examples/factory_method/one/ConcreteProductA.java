package oopstudy_solid.examples.factory_method.one;

public class ConcreteProductA implements IProduct{
    @Override
    public void setting() {
        System.out.println("Concrete Product A with IProduct");
    }
}
