package designPatterns.factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new MilkFactory();
        System.out.println("GOt a milk: "+ factory.createProduct());

    }
}
