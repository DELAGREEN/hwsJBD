package hw02.calc;


public class ExpressionValidator {
    
    public static boolean isValidExpression(String[] parts) {
        if (parts.length != 3) {
            return false;
        }
        
        try {
            Double.parseDouble(parts[0]);
            Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        
        String operator = parts[1];
        return operator.equals("+") || operator.equals("-") || 
               operator.equals("*") || operator.equals("/") || 
               operator.equals("//") || operator.equals("^") || 
               operator.equals("%");
    }
    
    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || 
               operator.equals("*") || operator.equals("/") || 
               operator.equals("//") || operator.equals("^") || 
               operator.equals("%");
    }
    
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}