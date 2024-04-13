package oopstudy_solid.examples.decorator;

public class Espresso implements Beverage {

    private String description = "Espresso";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
