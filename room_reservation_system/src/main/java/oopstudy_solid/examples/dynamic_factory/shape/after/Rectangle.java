package oopstudy_solid.examples.dynamic_factory.shape.after;

public class Rectangle implements Shape {
    String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle draw with "+ color);
    }
}
