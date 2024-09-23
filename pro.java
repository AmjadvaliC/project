import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        Map<String, java.util.function.BiFunction<Double, Double, Double>> operationsMap = new HashMap<>();
        operationsMap.put("+", Calculator::add);
        operationsMap.put("-", Calculator::subtract);
        operationsMap.put("*", Calculator::multiply);
        operationsMap.put("/", Calculator::divide);

        for (String symbol : operationsMap.keySet()) {
            System.out.println(symbol);
        }

        boolean continueFlag = true;
        while (continueFlag) {
            System.out.print("Pick an operation: ");
            String opSymbol = scanner.next();
            System.out.print("Enter the next number: ");
            double number2 = scanner.nextDouble();
            double output = operationsMap.get(opSymbol).apply(number1, number2);
            System.out.printf("%f %s %f = %f%n", number1, opSymbol, number2, output);
            System.out.printf("Enter 'y' to continue calculation with %f or 'n' to start a new calculation or 'x' to exit: ", output);
            String shouldContinue = scanner.next().toLowerCase();
            if (shouldContinue.equals("y")) {
                number1 = output;
            } else if (shouldContinue.equals("n")) {
                continueFlag = false;
                System.out.print("\033[H\033[2J"); // Clear console
                System.out.flush();
                calculator();
            } else {
                continueFlag = false;
                System.out.println("Thanks for choosing this calculator");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        calculator();
    }
}

