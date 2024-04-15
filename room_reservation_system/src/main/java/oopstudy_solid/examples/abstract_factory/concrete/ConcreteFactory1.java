package oopstudy_solid.examples.abstract_factory.concrete;

import oopstudy_solid.examples.abstract_factory.a.AbstractProductA;
import oopstudy_solid.examples.abstract_factory.a.ConcreteProductA1;
import oopstudy_solid.examples.abstract_factory.b.AbstractProductB;
import oopstudy_solid.examples.abstract_factory.b.ConcreteProductB1;
import oopstudy_solid.examples.abstract_factory.factory.AbstractFactory;

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
