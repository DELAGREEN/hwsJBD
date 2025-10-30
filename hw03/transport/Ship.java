package hw03.transport;

public final class Ship extends WaterTransport {
    public static final class ShipEngine extends Engine {
        public ShipEngine(EngineType engineType, FuelType fuelType, double power, int cylinders) {
            super(engineType, fuelType, power, cylinders);
        }
    }

    private final ShipEngine engine;
    private final int decks;

    public Ship(String model, int year, int capacity, double maxSpeed,
               double displacement, boolean hasSail, ShipEngine engine,
               int decks) {
        super(model, year, capacity, maxSpeed, displacement, hasSail);
        this.engine = engine;
        this.decks = decks;
    }

    @Override
    public void start() {
        System.out.println("Корабль " + model + " запускает двигатели");
        engine.start();
    }

    @Override
    public void stop() {
        System.out.println("Корабль " + model + " останавливает двигатели");
        engine.stop();
    }

    @Override
    public void anchor() {
        System.out.println("Корабль " + model + " бросает якорь");
    }

    @Override
    public void displayInfo() {
        System.out.println("=== ИНФОРМАЦИЯ О КОРАБЛЕ ===");
        System.out.println("Модель: " + model);
        System.out.println("Год: " + year);
        System.out.println("Вместимость: " + capacity + " пассажиров");
        System.out.println("Макс. скорость: " + maxSpeed + " узлов");
        System.out.println("Водоизмещение: " + displacement + " тонн");
        System.out.println("Есть паруса: " + (hasSail ? "Да" : "Нет"));
        System.out.println("Палубы: " + decks);
        System.out.println("Двигатель: " + engine);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * (engine.getPower() / 5000) * 0.5;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public FuelType getFuelType() {
        return engine.getFuelType();
    }

    public int getDecks() {
        return decks;
    }
}