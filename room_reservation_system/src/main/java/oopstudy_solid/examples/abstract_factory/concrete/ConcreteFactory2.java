package oopstudy_solid.examples.abstract_factory.concrete;

import oopstudy_solid.examples.abstract_factory.a.AbstractProductA;
import oopstudy_solid.examples.abstract_factory.a.ConcreteProductA2;
import oopstudy_solid.examples.abstract_factory.b.AbstractProductB;
import oopstudy_solid.examples.abstract_factory.b.ConcreteProductB2;
import oopstudy_solid.examples.abstract_factory.factory.AbstractFactory;

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
