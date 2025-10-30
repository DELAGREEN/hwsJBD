package hw03.main.transport;

public abstract sealed class AirTransport extends Transport 
    permits Airplane {
    
    protected final double wingspan;
    protected final double maxAltitude;

    public AirTransport(String model, int year, int capacity, double maxSpeed,
                       double wingspan, double maxAltitude) {
        super(model, year, capacity, maxSpeed);
        this.wingspan = wingspan;
        this.maxAltitude = maxAltitude;
    }

    public abstract void takeOff();
    public abstract void land();

    public double getWingspan() {
        return wingspan;
    }

    public double getMaxAltitude() {
        return maxAltitude;
    }
}