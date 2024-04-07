package oopstudy_solid.examples.decorator;

public class HouseBlend implements Beverage{

    private String description = "House Blend";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return .89;
    }
}
