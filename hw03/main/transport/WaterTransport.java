package hw03.main.transport;

public abstract sealed class WaterTransport extends Transport 
    permits Ship {
    
    protected final double displacement;
    protected final boolean hasSail;

    public WaterTransport(String model, int year, int capacity, double maxSpeed,
                         double displacement, boolean hasSail) {
        super(model, year, capacity, maxSpeed);
        this.displacement = displacement;
        this.hasSail = hasSail;
    }

    public abstract void anchor();

    public double getDisplacement() {
        return displacement;
    }

    public boolean hasSail() {
        return hasSail;
    }
}
