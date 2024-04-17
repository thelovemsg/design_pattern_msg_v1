package oopstudy_solid.examples.dynamic_factory.shape.after;

public class Triangle implements Shape {

    String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Triangle draw!");
    }
}
