package oopstudy_solid.examples.dynamic_factory.shape.before;

public interface ShapeFactory {
    default Shape create(String color) {
        Shape shape = createShape();
        shape.setColor(color);
        return shape;
    }

    Shape createShape();
}
