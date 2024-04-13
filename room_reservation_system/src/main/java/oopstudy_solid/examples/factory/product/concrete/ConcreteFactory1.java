package oopstudy_solid.examples.factory.product.concrete;

import oopstudy_solid.examples.factory.product.a.AbstractProductA;
import oopstudy_solid.examples.factory.product.a.ConcreteProductA1;
import oopstudy_solid.examples.factory.product.b.AbstractProductB;
import oopstudy_solid.examples.factory.product.b.ConcreteProductB1;
import oopstudy_solid.examples.factory.product.factory.AbstractFactory;

public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}
