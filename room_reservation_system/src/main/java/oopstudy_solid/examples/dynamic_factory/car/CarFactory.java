package oopstudy_solid.examples.dynamic_factory.car;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CarFactory {

    private static final Map<String, Supplier<Car>> carMap = new HashMap<>();

    static {
        registerCar("sports", SportsCar::new);
        registerCar("family", FamilyCar::new);
    }

    public static void registerCar(String type, Supplier<Car> supplier) {
        carMap.put(type, supplier);
    }

    public static Car getCar(String type) {
        Supplier<Car> carSupplier = carMap.get(type);
        if (carSupplier != null) {
            return carSupplier.get();
        }
        throw new IllegalArgumentException("No such car type available " + type);
    }

}
