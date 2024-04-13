package oopstudy_solid.examples.decorator;

public abstract class CondimentDecorator implements Beverage{
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
}
