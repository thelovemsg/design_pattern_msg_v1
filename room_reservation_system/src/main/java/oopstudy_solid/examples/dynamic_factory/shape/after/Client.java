package oopstudy_solid.examples.dynamic_factory.shape.after;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = DynamicShapeFactory.create("Rectangle", "red");
        rectangle.draw();

        Shape circle = DynamicShapeFactory.create("Circle", "yellow");
        circle.draw();

        DynamicShapeFactory.registerType("Triangle", Triangle.class);
        Shape triangle = DynamicShapeFactory.create("Triangle", "green");
        triangle.draw();
    }
}
