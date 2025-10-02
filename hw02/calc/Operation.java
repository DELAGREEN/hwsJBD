package hw02.calc;


// Абстрактный класс для операций
public abstract class Operation {
    protected double operand1;
    protected double operand2;
    
    public Operation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    
    // Абстрактный метод для выполнения операции
    public abstract double execute();
    
    // Геттеры
    public double getOperand1() {
        return operand1;
    }
    
    public double getOperand2() {
        return operand2;
    }
}