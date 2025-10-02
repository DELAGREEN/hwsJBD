package hw02.calc;

import java.text.DecimalFormat;


// Основной класс калькулятора
public class Main {
    private static final DecimalFormat df = new DecimalFormat("#.#####");
    
    // Метод для создания операции на основе оператора
    public Operation createOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return new Addition(operand1, operand2);
            case "-":
                return new Subtraction(operand1, operand2);
            case "*":
                return new Multiplication(operand1, operand2);
            case "/":
                return new Division(operand1, operand2);
            case "//":
                return new IntegerDivision(operand1, operand2);
            case "^":
                return new Power(operand1, operand2);
            case "%":
                return new Modulus(operand1, operand2);
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
    
    // Метод для вычисления результата операции
    public double calculate(double operand1, double operand2, String operator) {
        Operation operation = createOperation(operand1, operand2, operator);
        return operation.execute();
    }
    
    // Метод для форматированного вывода числа
    public static String formatNumber(double number) {
        if (number == (long) number) {
            // Если число целое, выводим без дробной части
            return String.valueOf((long) number);
        } else {
            // Если число дробное, форматируем с ограничением знаков после запятой
            return df.format(number);
        }
    }
}