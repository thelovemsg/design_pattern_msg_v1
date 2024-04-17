package oopstudy_solid.examples.dynamic_factory.shape.before;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new RectangleFactory().create("red");
        rectangle.draw();

        Shape circle = new CircleFactory().create("yellow");
        circle.draw();
    }

}
