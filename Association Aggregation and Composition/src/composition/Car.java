package composition;

public class Car {
    String name;
    float price;
    Engine engine;

    public Car(String name, float price) {
        this.name = name;
        this.price = price;
        engine = new Engine(7);
    }

    void showcar(){
        System.out.println(name);
        System.out.println(price);
        System.out.println(engine.gen);
    }

    public static void main(String[] args) {
        Car car =new Car("BMW",120000.00f);
        car.showcar();
    }
}
