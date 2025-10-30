package hw03.main.transport;

public abstract sealed class RoadTransport extends Transport 
    permits Car, Motorcycle {

    protected final int wheels;
    protected final String licenseCategory;

    public RoadTransport(String model, 
                        int year,
                        int capacity,
                        double maxSpeed,
                        int wheels,
                        String licenseCategory
                        )
    
}
