package hw02.calc;


public class Power extends Operation {
    public Power(double operand1, double operand2) {
        super(operand1, operand2);
    }
    
    @Override
    public double execute() {
        return Math.pow(operand1, operand2);
    }
}
