package designPatterns.factory;

public class MilkFactory extends Factory{
    @Override
    Product createProduct() {
        return new Milk();
    }
}
