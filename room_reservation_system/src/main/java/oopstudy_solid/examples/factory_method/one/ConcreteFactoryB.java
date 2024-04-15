package oopstudy_solid.examples.factory_method.one;

public class ConcreteFactoryB extends AbstractFactory{
    @Override
    protected IProduct createProduct() {
        return new ConcreteProductB();
    }
}
