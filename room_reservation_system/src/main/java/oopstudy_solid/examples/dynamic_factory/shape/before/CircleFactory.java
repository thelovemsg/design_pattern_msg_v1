package oopstudy_solid.examples.dynamic_factory.shape.before;

public class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
