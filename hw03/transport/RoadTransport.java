package hw03.transport;

public abstract sealed class RoadTransport extends Transport 
    permits Car, Motorcycle {
    
    protected final int wheels;
    protected final String licenseCategory;

    public RoadTransport(String model, int year, int capacity, double maxSpeed, 
                        int wheels, String licenseCategory) {
        super(model, year, capacity, maxSpeed);
        this.wheels = wheels;
        this.licenseCategory = licenseCategory;
    }

    public abstract void honk();

    public int getWheels() {
        return wheels;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }
}
