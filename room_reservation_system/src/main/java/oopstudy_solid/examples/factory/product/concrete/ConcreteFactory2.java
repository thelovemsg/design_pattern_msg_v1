package oopstudy_solid.examples.factory.product.concrete;

import oopstudy_solid.examples.factory.product.a.AbstractProductA;
import oopstudy_solid.examples.factory.product.a.ConcreteProductA2;
import oopstudy_solid.examples.factory.product.b.AbstractProductB;
import oopstudy_solid.examples.factory.product.b.ConcreteProductB2;
import oopstudy_solid.examples.factory.product.factory.AbstractFactory;

public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}
