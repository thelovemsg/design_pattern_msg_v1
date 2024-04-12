package oopstudy_solid.examples.factory.product.factory;

import oopstudy_solid.examples.factory.product.a.AbstractProductA;
import oopstudy_solid.examples.factory.product.b.AbstractProductB;

public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}
