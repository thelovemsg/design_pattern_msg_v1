package oopstudy_solid.examples.factory_method.one;

public class Client {
    public static void main(String[] args) {
        AbstractFactory[] factory = {
            new ConcreteFactoryA(),
            new ConcreteFactoryB()
        };

        IProduct productA = factory[0].createOperation();
        IProduct productB = factory[1].createOperation();

    }
}
