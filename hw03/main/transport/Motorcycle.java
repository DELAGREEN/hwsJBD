package hw03.main.transport;

public final class Motorcycle extends RoadTransport {
    public static final class MotorcycleEngine extends Engine {
        public MotorcycleEngine(EngineType engineType, FuelType fuelType, double power, int cylinders) {
            super(engineType, fuelType, power, cylinders);
        }
    }

    private final MotorcycleEngine engine;
    private final boolean hasSidecar;

    public Motorcycle(String model, int year, int capacity, double maxSpeed,
                     int wheels, String licenseCategory, MotorcycleEngine engine,
                     boolean hasSidecar) {
        super(model, year, capacity, maxSpeed, wheels, licenseCategory);
        this.engine = engine;
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println("Мотоцикл " + model + " заводится");
        engine.start();
    }

    @Override
    public void stop() {
        System.out.println("Мотоцикл " + model + " останавливается");
        engine.stop();
    }

    @Override
    public void honk() {
        System.out.println("Бип! Мотоцикл " + model + " сигналит");
    }

    @Override
    public void displayInfo() {
        System.out.println("=== ИНФОРМАЦИЯ О МОТОЦИКЛЕ ===");
        System.out.println("Модель: " + model);
        System.out.println("Год: " + year);
        System.out.println("Вместимость: " + capacity + " человек");
        System.out.println("Макс. скорость: " + maxSpeed + " км/ч");
        System.out.println("Колеса: " + wheels);
        System.out.println("Категория прав: " + licenseCategory);
        System.out.println("Есть коляска: " + (hasSidecar ? "Да" : "Нет"));
        System.out.println("Двигатель: " + engine);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * (engine.getPower() / 500) * 0.08;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public FuelType getFuelType() {
        return engine.getFuelType();
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }
}