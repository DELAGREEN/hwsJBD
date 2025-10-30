package hw03.main.engine;

public enum EngineType {
    INTERNAL_COMBUSTION("Двигатель внутреннего сгорания"),
    ELECTRIC_MOTOR("Электродвигатель"),
    JET_ENGINE("Реактивный двигатель"),
    PROPELLER("Пропеллер");

    private final String description;

    EngineType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}