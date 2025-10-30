package hw03.main.transport;

public final class Airplane extends AirTransport {
    public static final class AirplaneEngine extends Engine {
        public AirplaneEngine(EngineType engineType, FuelType fuelType, double power, int cylinders) {
            super(engineType, fuelType, power, cylinders);
        }
    }

    private final AirplaneEngine engine;
    private final int enginesCount;

    public Airplane(String model, int year, int capacity, double maxSpeed,
                   double wingspan, double maxAltitude, AirplaneEngine engine,
                   int enginesCount) {
        super(model, year, capacity, maxSpeed, wingspan, maxAltitude);
        this.engine = engine;
        this.enginesCount = enginesCount;
    }

    @Override
    public void start() {
        System.out.println("Самолет " + model + " запускает двигатели");
        engine.start();
    }

    @Override
    public void stop() {
        System.out.println("Самолет " + model + " останавливает двигатели");
        engine.stop();
    }

    @Override
    public void takeOff() {
        System.out.println("Самолет " + model + " взлетает");
    }

    @Override
    public void land() {
        System.out.println("Самолет " + model + " приземляется");
    }

    @Override
    public void displayInfo() {
        System.out.println("=== ИНФОРМАЦИЯ О САМОЛЕТЕ ===");
        System.out.println("Модель: " + model);
        System.out.println("Год: " + year);
        System.out.println("Вместимость: " + capacity + " пассажиров");
        System.out.println("Макс. скорость: " + maxSpeed + " км/ч");
        System.out.println("Размах крыльев: " + wingspan + " м");
        System.out.println("Макс. высота: " + maxAltitude + " м");
        System.out.println("Количество двигателей: " + enginesCount);
        System.out.println("Двигатель: " + engine);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * (engine.getPower() / 10000) * 2.5;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public FuelType getFuelType() {
        return engine.getFuelType();
    }

    public int getEnginesCount() {
        return enginesCount;
    }
}