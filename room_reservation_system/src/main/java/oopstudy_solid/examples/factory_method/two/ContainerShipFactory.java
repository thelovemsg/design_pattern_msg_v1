package oopstudy_solid.examples.factory_method.two;

class ContainerShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new ContainerShip("ContainerShip", "green", "20t");
    }
}
