package oopstudy_solid.examples.factory_method.one;

public class ConcreteFactoryA extends AbstractFactory{
    @Override
    protected IProduct createProduct() {
        return new ConcreteProductA();
    }
}
