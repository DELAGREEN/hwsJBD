package hw03.transport;

public final class Car extends RoadTransport {
    public static final class CarEngine extends Engine {
        public CarEngine(EngineType engineType, FuelType fuelType, double power, int cylinders) {
            super(engineType, fuelType, power, cylinders);
        }
    }

    private final CarEngine engine;
    private final int doors;
    private final String transmission;

    public Car(String model, int year, int capacity, double maxSpeed, 
               int wheels, String licenseCategory, CarEngine engine, 
               int doors, String transmission) {
        super(model, year, capacity, maxSpeed, wheels, licenseCategory);
        this.engine = engine;
        this.doors = doors;
        this.transmission = transmission;
    }

    @Override
    public void start() {
        System.out.println("Автомобиль " + model + " заводится");
        engine.start();
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль " + model + " останавливается");
        engine.stop();
    }

    @Override
    public void honk() {
        System.out.println("Би-бип! Автомобиль " + model + " сигналит");
    }

    @Override
    public void displayInfo() {
        System.out.println("=== ИНФОРМАЦИЯ ОБ АВТОМОБИЛЕ ===");
        System.out.println("Модель: " + model);
        System.out.println("Год: " + year);
        System.out.println("Вместимость: " + capacity + " человек");
        System.out.println("Макс. скорость: " + maxSpeed + " км/ч");
        System.out.println("Колеса: " + wheels);
        System.out.println("Категория прав: " + licenseCategory);
        System.out.println("Двери: " + doors);
        System.out.println("Коробка передач: " + transmission);
        System.out.println("Двигатель: " + engine);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * (engine.getPower() / 1000) * 0.1;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public FuelType getFuelType() {
        return engine.getFuelType();
    }

    public int getDoors() {
        return doors;
    }

    public String getTransmission() {
        return transmission;
    }
}