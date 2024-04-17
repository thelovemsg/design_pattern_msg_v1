package oopstudy_solid.examples.dynamic_factory.shape.before;

public class Circle implements Shape{

    String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle draw with " + color);
    }
}
