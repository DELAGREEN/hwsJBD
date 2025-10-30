package hw03.main.transport;

import hw03.main.engine.Engine;
import hw03.main.engine.FuelType;

public abstract sealed class Transport 
    permits RoadTransport, WaterTransport, AirTransport {

    protected final String model; 
    protected final int year;
    protected final int capacity;
    protected final double maxSpeed;

    public Transport(String model, int year, int capacity, double maxSpeed) {
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
    
}
