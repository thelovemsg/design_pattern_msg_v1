package oopstudy_solid.examples.factory_method.two;

class OilTankerShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new OilTankerShip("OilTankerShip", "blue", "15t");
    }
}
