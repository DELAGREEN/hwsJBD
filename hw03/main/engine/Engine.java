package hw03.main.engine;

import hw03.main.transport.Airplane;
import hw03.main.transport.Car;
import hw03.main.transport.Motorcycle;
import hw03.main.transport.Ship;

public sealed class Engine permits Car.Engine, Motorcycle.Engine, Airplane.Engine, Ship.Engine {
    private final EngineType engineType;
    private final FuelType fuelType;
    private final double power;
    private final int cylinders;

    public Engine(EngineType engineType, FuelType fuelType, double power, int cylinders) {
        
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.power = power;
        this.cylinders = cylinders;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getPower() {
        return power;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void start() {
        System.out.println("Двигатель запущен: " + engineType,getDescription());
    }

    public void stop() {
        System.out.println("Двигатель остановлен");
    }

    @Override
    public String toString() {
        return String.format("Тип: %s, Топливо: %s, Мощность: %.1f л.с., Цилиндры: %d",
        engineType.getDescription(), fuelType.getDescription(), power, cylinders);
    }
}

    

