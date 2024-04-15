package oopstudy_solid.examples.factory_method.one;

abstract class AbstractFactory {
    final IProduct createOperation() {
        IProduct product = createProduct();
        product.setting();
        return product;
    }

    protected abstract IProduct createProduct();
}
