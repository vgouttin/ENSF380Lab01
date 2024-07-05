package com.VictorGouttin.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
            processCLIArgs(args);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (ex: add, subtract, multiply, divide, factorial)");
            String operation = scanner.next();
            // Further processing based on operation
            switch (operation.toLowerCase()) {
                case "add":
                    System.out.println("Enter the first operand:");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case "subtract":
                    System.out.println("Enter the first operand:");
                    double num3 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num4 = scanner.nextDouble();
                    System.out.println("Result: " + subtract(num3, num4));
                    break;
                case "multiply":
                    System.out.println("Enter the first operand:");
                    double num5 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num6 = scanner.nextDouble();
                    System.out.println("Result: " + multiply(num5, num6));
                    break;
                case "divide":
                    System.out.println("Enter the first operand:");
                    double num7 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num8 = scanner.nextDouble();
                    System.out.println("Result: " + divide(num7, num8));
                    break;
                case "factorial":
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    System.out.println("Result: " + factorial(number));
                    break;
                default:
                    System.out.println("Unknown operation. Supported operations: add, subtract, multiply, divide, factorial.");
                    break;
            }
        }
    }

    // Methods for calculations
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
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Method to process CLI arguments
    public static void processCLIArgs(String[] args) {
        if (args.length < 2 || (args.length < 3 && !args[1].equals("!"))) {
            System.out.println("Insufficient arguments provided. Usage examples: 5 + 3, 5 !");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            String operation = args[1];
            double num2 = args.length == 3 ? Double.parseDouble(args[2]) : 0;

            switch (operation) {
                case "+":
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case "-":
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case "x":
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case "/":
                    try {
                        System.out.println("Result: " + divide(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "!":
                    System.out.println("Result: " + factorial(num1));
                    break;
                default:
                    System.out.println("Unknown operation. Supported operations: +, -, *, /, !");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please ensure you enter valid numbers.");
        }
    }
}
