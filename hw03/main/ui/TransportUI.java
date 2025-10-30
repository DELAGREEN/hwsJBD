package hw03.main.ui;

import hw03.main.transport.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportUI {
    private final List<Transport> transports;
    private final Scanner scanner;

    public TransportUI() {
        this.transports = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ТРАНСПОРТОМ ===");
        
        // Создаем несколько транспортных средств по умолчанию
        createSampleTransports();
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1 -> createTransport();
                case 2 -> listTransports();
                case 3 -> operateTransport();
                case 4 -> calculateFuel();
                case 5 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Создать новый транспорт");
        System.out.println("2. Показать список транспорта");
        System.out.println("3. Управлять транспортом");
        System.out.println("4. Рассчитать расход топлива");
        System.out.println("5. Выход");
    }

    private void createSampleTransports() {
        // Автомобиль
        Car.CarEngine carEngine = new Car.CarEngine(
            EngineType.INTERNAL_COMBUSTION, 
            FuelType.GASOLINE, 
            150, 
            4
        );
        Car car = new Car("Toyota Camry", 2022, 5, 220, 4, "B", 
                         carEngine, 4, "Автоматическая");
        transports.add(car);

        // Мотоцикл
        Motorcycle.MotorcycleEngine bikeEngine = new Motorcycle.MotorcycleEngine(
            EngineType.INTERNAL_COMBUSTION,
            FuelType.GASOLINE,
            80,
            2
        );
        Motorcycle motorcycle = new Motorcycle("Yamaha R1", 2023, 2, 299, 
                                             2, "A", bikeEngine, false);
        transports.add(motorcycle);

        // Самолет
        Airplane.AirplaneEngine planeEngine = new Airplane.AirplaneEngine(
            EngineType.JET_ENGINE,
            FuelType.KEROSENE,
            25000,
            8
        );
        Airplane airplane = new Airplane("Boeing 737", 2020, 189, 850, 
                                       35.8, 12500, planeEngine, 2);
        transports.add(airplane);

        // Корабль
        Ship.ShipEngine shipEngine = new Ship.ShipEngine(
            EngineType.INTERNAL_COMBUSTION,
            FuelType.DIESEL,
            5000,
            12
        );
        Ship ship = new Ship("Queen Mary 2", 2018, 2620, 30, 
                           151400, false, shipEngine, 12);
        transports.add(ship);
    }

    private void createTransport() {
        System.out.println("\n=== СОЗДАНИЕ НОВОГО ТРАНСПОРТА ===");
        System.out.println("1. Автомобиль");
        System.out.println("2. Мотоцикл");
        System.out.println("3. Самолет");
        System.out.println("4. Корабль");
        
        int choice = getIntInput("Выберите тип транспорта: ");
        
        switch (choice) {
            case 1 -> createCar();
            case 2 -> createMotorcycle();
            case 3 -> createAirplane();
            case 4 -> createShip();
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void createCar() {
        System.out.println("\n--- Создание автомобиля ---");
        String model = getStringInput("Модель: ");
        int year = getIntInput("Год: ");
        int capacity = getIntInput("Вместимость: ");
        double maxSpeed = getDoubleInput("Макс. скорость (км/ч): ");
        
        Car.CarEngine engine = createCarEngine();
        int doors = getIntInput("Количество дверей: ");
        String transmission = getStringInput("Коробка передач: ");
        
        Car car = new Car(model, year, capacity, maxSpeed, 4, "B", 
                         engine, doors, transmission);
        transports.add(car);
        System.out.println("Автомобиль создан успешно!");
    }

    private Car.CarEngine createCarEngine() {
        System.out.println("--- Двигатель автомобиля ---");
        System.out.println("1. Бензиновый");
        System.out.println("2. Дизельный");
        System.out.println("3. Электрический");
        int engineChoice = getIntInput("Выберите тип двигателя: ");
        
        EngineType engineType;
        FuelType fuelType;
        
        switch (engineChoice) {
            case 1 -> { engineType = EngineType.INTERNAL_COMBUSTION; fuelType = FuelType.GASOLINE; }
            case 2 -> { engineType = EngineType.INTERNAL_COMBUSTION; fuelType = FuelType.DIESEL; }
            case 3 -> { engineType = EngineType.ELECTRIC_MOTOR; fuelType = FuelType.ELECTRIC; }
            default -> { engineType = EngineType.INTERNAL_COMBUSTION; fuelType = FuelType.GASOLINE; }
        }
        
        double power = getDoubleInput("Мощность (л.с.): ");
        int cylinders = getIntInput("Количество цилиндров: ");
        
        return new Car.CarEngine(engineType, fuelType, power, cylinders);
    }

    private void createMotorcycle() {
        System.out.println("\n--- Создание мотоцикла ---");
        String model = getStringInput("Модель: ");
        int year = getIntInput("Год: ");
        int capacity = getIntInput("Вместимость: ");
        double maxSpeed = getDoubleInput("Макс. скорость (км/ч): ");
        
        Motorcycle.MotorcycleEngine engine = createMotorcycleEngine();
        boolean hasSidecar = getBooleanInput("Есть коляска (да/нет): ");
        
        Motorcycle motorcycle = new Motorcycle(model, year, capacity, maxSpeed, 
                                             2, "A", engine, hasSidecar);
        transports.add(motorcycle);
        System.out.println("Мотоцикл создан успешно!");
    }

    private Motorcycle.MotorcycleEngine createMotorcycleEngine() {
        System.out.println("--- Двигатель мотоцикла ---");
        double power = getDoubleInput("Мощность (л.с.): ");
        int cylinders = getIntInput("Количество цилиндров: ");
        
        return new Motorcycle.MotorcycleEngine(
            EngineType.INTERNAL_COMBUSTION, 
            FuelType.GASOLINE, 
            power, 
            cylinders
        );
    }

    private void createAirplane() {
        System.out.println("\n--- Создание самолета ---");
        String model = getStringInput("Модель: ");
        int year = getIntInput("Год: ");
        int capacity = getIntInput("Вместимость: ");
        double maxSpeed = getDoubleInput("Макс. скорость (км/ч): ");
        double wingspan = getDoubleInput("Размах крыльев (м): ");
        double maxAltitude = getDoubleInput("Макс. высота (м): ");
        int enginesCount = getIntInput("Количество двигателей: ");
        
        Airplane.AirplaneEngine engine = createAirplaneEngine();
        
        Airplane airplane = new Airplane(model, year, capacity, maxSpeed,
                                       wingspan, maxAltitude, engine, enginesCount);
        transports.add(airplane);
        System.out.println("Самолет создан успешно!");
    }

    private Airplane.AirplaneEngine createAirplaneEngine() {
        System.out.println("--- Двигатель самолета ---");
        double power = getDoubleInput("Мощность (л.с.): ");
        int cylinders = getIntInput("Количество цилиндров: ");
        
        return new Airplane.AirplaneEngine(
            EngineType.JET_ENGINE, 
            FuelType.KEROSENE, 
            power, 
            cylinders
        );
    }

    private void createShip() {
        System.out.println("\n--- Создание корабля ---");
        String model = getStringInput("Модель: ");
        int year = getIntInput("Год: ");
        int capacity = getIntInput("Вместимость: ");
        double maxSpeed = getDoubleInput("Макс. скорость (узлов): ");
        double displacement = getDoubleInput("Водоизмещение (тонн): ");
        boolean hasSail = getBooleanInput("Есть паруса (да/нет): ");
        int decks = getIntInput("Количество палуб: ");
        
        Ship.ShipEngine engine = createShipEngine();
        
        Ship ship = new Ship(model, year, capacity, maxSpeed,
                           displacement, hasSail, engine, decks);
        transports.add(ship);
        System.out.println("Корабль создан успешно!");
    }

    private Ship.ShipEngine createShipEngine() {
        System.out.println("--- Двигатель корабля ---");
        double power = getDoubleInput("Мощность (л.с.): ");
        int cylinders = getIntInput("Количество цилиндров: ");
        
        return new Ship.ShipEngine(
            EngineType.INTERNAL_COMBUSTION, 
            FuelType.DIESEL, 
            power, 
            cylinders
        );
    }

    private void listTransports() {
        System.out.println("\n=== СПИСОК ТРАНСПОРТНЫХ СРЕДСТВ ===");
        if (transports.isEmpty()) {
            System.out.println("Транспортные средства не найдены.");
            return;
        }
        
        for (int i = 0; i < transports.size(); i++) {
            Transport transport = transports.get(i);
            System.out.printf("%d. %s (%s)%n", i + 1, transport.getModel(), 
                             transport.getClass().getSimpleName());
        }
    }

    private void operateTransport() {
        listTransports();
        if (transports.isEmpty()) return;
        
        int index = getIntInput("Выберите транспорт для управления: ") - 1;
        if (index < 0 || index >= transports.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        
        Transport transport = transports.get(index);
        
        System.out.println("\n=== УПРАВЛЕНИЕ " + transport.getModel().toUpperCase() + " ===");
        transport.displayInfo();
        System.out.println();
        
        System.out.println("1. Запустить");
        System.out.println("2. Остановить");
        
        if (transport instanceof RoadTransport) {
            System.out.println("3. Подать сигнал");
        } else if (transport instanceof AirTransport) {
            System.out.println("3. Взлететь");
            System.out.println("4. Приземлиться");
        } else if (transport instanceof WaterTransport) {
            System.out.println("3. Бросить якорь");
        }
        
        int choice = getIntInput("Выберите действие: ");
        
        switch (choice) {
            case 1 -> transport.start();
            case 2 -> transport.stop();
            case 3 -> {
                if (transport instanceof RoadTransport) ((RoadTransport) transport).honk();
                else if (transport instanceof AirTransport) ((AirTransport) transport).takeOff();
                else if (transport instanceof WaterTransport) ((WaterTransport) transport).anchor();
            }
            case 4 -> {
                if (transport instanceof AirTransport) ((AirTransport) transport).land();
            }
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void calculateFuel() {
        listTransports();
        if (transports.isEmpty()) return;
        
        int index = getIntInput("Выберите транспорт для расчета: ") - 1;
        if (index < 0 || index >= transports.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        
        Transport transport = transports.get(index);
        double distance = getDoubleInput("Введите расстояние (км): ");
        
        double consumption = transport.calculateFuelConsumption(distance);
        System.out.printf("Расход топлива на %.1f км: %.2f литров %s%n", 
                         distance, consumption, transport.getFuelType().getDescription());
    }

    // Вспомогательные методы для ввода
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
            }
        }
    }

    private boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("да") || input.equals("д") || input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("нет") || input.equals("н") || input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Пожалуйста, введите 'да' или 'нет'.");
            }
        }
    }
}