package oopstudy_solid.examples.abstract_factory;


import oopstudy_solid.examples.abstract_factory.a.AbstractProductA;
import oopstudy_solid.examples.abstract_factory.concrete.ConcreteFactory1;
import oopstudy_solid.examples.abstract_factory.concrete.ConcreteFactory2;
import oopstudy_solid.examples.abstract_factory.factory.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = null;

        // 1. 공장군 1을 가동시킨다.
        factory = new ConcreteFactory1();

        // 2. 공장군 1을 통해 제품군 A1를 생성하도록 한다 (클라이언트는 구체적인 구현은 모르고 인터페이스에 의존한다)
        AbstractProductA product_A1 = factory.createProductA();
        System.out.println(product_A1.getClass().getName()); // ConcreteProductA1

        // 3. 공장군 2를 가동시킨다.
        factory = new ConcreteFactory2();

        // 4. 공장군 2를 통해 제품군 A2를 생성하도록 한다 (클라이언트는 구체적인 구현은 모르고 인터페이스에 의존한다)
        AbstractProductA product_A2 = factory.createProductA();
        System.out.println(product_A2.getClass().getName()); // ConcreteProductA2
    }
}
