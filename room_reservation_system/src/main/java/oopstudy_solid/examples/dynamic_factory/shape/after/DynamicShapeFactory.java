package oopstudy_solid.examples.dynamic_factory.shape.after;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DynamicShapeFactory {

    private static final Map<String, Class<? extends Shape>> registeredTypes = new HashMap<>();

    // 팩토리 객체가 생성됨에 동시에 미리 등록
    static {
        registeredTypes.put("Rectangle", Rectangle.class);
        registeredTypes.put("Circle", Circle.class);
    }

    public static void registerType(String type, Class<? extends Shape> cls) {
        registeredTypes.put(type, cls);
    }

    public static Shape create(String type, String color) {
        Shape shape = null;

        try {
            shape = getShape(type);
            shape.setColor(color);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return shape;
    }

    private static Shape getShape(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cls = registeredTypes.get(type);
        Constructor<?> shapeConstructor = cls.getDeclaredConstructor();
        return (Shape)  shapeConstructor.newInstance();
    }

}
