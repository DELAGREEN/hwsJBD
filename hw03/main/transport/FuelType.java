package hw03.main.transport;

public enum FuelType {
    GASOLINE("Бензин"),
    DIESEL("Дизель"),
    ELECTRIC("Электричество"),
    KEROSENE("Керосин"),
    BIOFUEL("Биотоплево");

    private final String description;

    FuelType(String descrition) {
        this.description = descrition;
    }

    public String getDescription() {
        return description;
    }
}
