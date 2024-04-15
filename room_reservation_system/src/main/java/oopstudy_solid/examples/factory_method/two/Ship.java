package oopstudy_solid.examples.factory_method.two;

public class Ship {
    String name;
    String color;
    String capacity;

    @Override
    public String toString() {
        return String.format("Shop { name : '%s', color: '%s', logo: '%s' }", name, color, capacity);
    }

}
