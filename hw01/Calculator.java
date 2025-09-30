package hw01;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator {
    
    // Формат для красивого вывода чисел
    private static final DecimalFormat df = new DecimalFormat("#.#####");
    
    // Функция для проверки корректности выражения
    public static boolean isValidExpression(String[] parts) {
        // Проверяем, что выражение состоит из трех частей
        if (parts.length != 3) {
            return false;
        }
        
        // Проверяем, что первая и третья части являются числами
        try {
            Double.parseDouble(parts[0]);
            Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        
        // Проверяем, что оператор поддерживается
        String operator = parts[1];
        return operator.equals("+") || operator.equals("-") || 
               operator.equals("*") || operator.equals("/") || 
               operator.equals("//") || operator.equals("^") || 
               operator.equals("%");
    }
    
    // Функция для форматированного вывода числа
    public static String formatNumber(double number) {
        if (number == (long) number) {
            // Если число целое, выводим без дробной части
            return String.valueOf((long) number);
        } else {
            // Если число дробное, форматируем с ограничением знаков после запятой
            return df.format(number);
        }
    }
    
    // Функция сложения
    public static double sum(double a, double b) {
        return a + b;
    }
    
    // Функция вычитания
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // Функция умножения
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    // Функция деления с проверкой деления на ноль
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }
    
    // Функция целочисленного деления
    public static int integerDivide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (int)(a / b);
    }
    
    // Функция возведения в степень
    public static double power(double a, double b) {
        return Math.pow(a, b);
    }
    
    // Функция остатка от деления
    public static double modulus(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a % b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Вывод информации о поддерживаемых операциях
        System.out.println("=== ПРОСТОЙ КОНСОЛЬНЫЙ КАЛЬКУЛЯТОР ===");
        System.out.println("Поддерживаемые операции:");
        System.out.println("+  - сложение");
        System.out.println("-  - вычитание");
        System.out.println("*  - умножение");
        System.out.println("/  - деление");
        System.out.println("// - целочисленное деление");
        System.out.println("^  - возведение в степень");
        System.out.println("%  - остаток от деления");
        System.out.println("exit - выход из программы");
        System.out.println("Формат ввода: число оператор число (например: 5 + 3)");
        System.out.println("=====================================");
        
        // Основной цикл программы
        while (true) {
            System.out.print("Введите выражение:\n> ");
            String input = scanner.nextLine().trim();
            
            // Проверка команды выхода
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход...");
                break;
            }
            
            // Пропускаем пустые строки
            if (input.isEmpty()) {
                continue;
            }
            
            // Разбиваем ввод на части (число, оператор, число)
            String[] parts = input.split("\\s+");
            
            // Проверяем корректность выражеения
            if (!isValidExpression(parts)) {
                System.out.println("Неверное выражение. Введите еще раз:");
                continue;
            }
            
            try {
                // Парсим числа
                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[2]);
                String operator = parts[1];
                
                double result;
                int intResult;
                
                // Выполняем операцию в зависимости от оператора
                switch (operator) {
                    case "+":
                        result = sum(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                    case "-":
                        result = subtract(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                    case "*":
                        result = multiply(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                    case "/":
                        result = divide(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                    case "//":
                        intResult = integerDivide(num1, num2);
                        System.out.println("Результат: " + intResult);
                        break;
                    case "^":
                        result = power(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                    case "%":
                        result = modulus(num1, num2);
                        System.out.println("Результат: " + formatNumber(result));
                        break;
                }
                
            } catch (ArithmeticException e) {
                // Обработка деления на ноль
                System.out.println("Ошибка - " + e.getMessage().toLowerCase() + ".");
            } catch (Exception e) {
                // Обработка других ошибок
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}