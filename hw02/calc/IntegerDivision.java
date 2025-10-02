package hw02.calc;


public class IntegerDivision extends Operation {
    public IntegerDivision(double operand1, double operand2) {
        super(operand1, operand2);
    }
    
    @Override
    public double execute() {
        if (operand2 == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (int)(operand1 / operand2);
    }
}