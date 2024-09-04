// Class and Object
class Car {
    String brand;
    int year;

    // Class constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Method overloading
    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    void display(String message) {
        System.out.println(message + " - Brand: " + brand + ", Year: " + year);
    }
}

// Inheritance
class SportsCar extends Car {
    boolean isConvertible;

    public SportsCar(String brand, int year, boolean isConvertible) {
        super(brand, year);
        this.isConvertible = isConvertible;
    }

    // Method overriding
    @Override
    void display() {
        System.out.println("Sports Car - Brand: " + brand + ", Year: " + year + ", Convertible: " + isConvertible);
    }
}

// Interface
interface Engine {
    void start();
    void stop();
}

// Abstract class
abstract class Vehicle {
    abstract void drive();
}

// Abstraction and Encapsulation
class Bike extends Vehicle {
    private String model;

    public Bike(String model) {
        this.model = model;
    }

    // Encapsulation
    public String getModel() {
        return model;
    }

    // Abstraction
    @Override
    void drive() {
        System.out.println("Bike is in motion.");
    }
}

// Composition and Aggregation
class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }
}

class Taxi {
    Car car;
    Driver driver;

    public Taxi(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    void displayInfo() {
        System.out.println("Taxi Information - Driver: " + driver.name);
        car.display();
    }
}

// Generalization and Specialization
class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

public class OOPConceptsExample {
    public static void main(String[] args) {
        // Class and Object
        Car myCar = new Car("Toyota", 2022);

        // Method overloading
        myCar.display();
        myCar.display("Car details");

        // Inheritance and Method overriding
        SportsCar mySportsCar = new SportsCar("Porsche", 2023, true);
        mySportsCar.display();

        // Interface
        Engine carEngine = new Engine() {
            @Override
            public void start() {
                System.out.println("Car engine started.");
            }

            @Override
            public void stop() {
                System.out.println("Car engine stopped.");
            }
        };

        carEngine.start();
        carEngine.stop();

        // Abstract class and Abstraction
        Bike myBike = new Bike("BMX");
        myBike.drive();

        // Composition and Aggregation
        Driver taxiDriver = new Driver("John");
        Taxi myTaxi = new Taxi(myCar, taxiDriver);
        myTaxi.displayInfo();

        // Generalization and Specialization
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();
    }
}
