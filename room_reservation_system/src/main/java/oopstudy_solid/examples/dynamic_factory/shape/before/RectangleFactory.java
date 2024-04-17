package oopstudy_solid.examples.dynamic_factory.shape.before;

public class RectangleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
