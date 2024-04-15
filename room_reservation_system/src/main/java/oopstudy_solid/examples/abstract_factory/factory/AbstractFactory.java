package oopstudy_solid.examples.abstract_factory.factory;

import oopstudy_solid.examples.abstract_factory.a.AbstractProductA;
import oopstudy_solid.examples.abstract_factory.b.AbstractProductB;

public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}
