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
                    System.out.println("Result: " + add(num1, num2));//prints addition
                    break;
                case "subtract":
                    System.out.println("Enter the first operand:");
                    double num3 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num4 = scanner.nextDouble();
                    System.out.println("Result: " + subtract(num3, num4));//prints subtraction
                    break;
                case "multiply":
                    System.out.println("Enter the first operand:");
                    double num5 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num6 = scanner.nextDouble();
                    System.out.println("Result: " + multiply(num5, num6));//prints multiplication
                    break;
                case "divide":
                    System.out.println("Enter the first operand:");
                    double num7 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num8 = scanner.nextDouble();
                    System.out.println("Result: " + divide(num7, num8));//prints division
                    break;
                case "factorial":
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    System.out.println("Result: " + factorial((int)number));//computes factorial and turn num1 into an int
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
            throw new ArithmeticException("Cannot divide by zero, please try again");
        }
        return a / b;
    }

 // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }
        // Calculate progress and update progress bar
        int progress = (int) (((originalNum - num) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
        /*The problem with the progress bar not reaching 1 is that it is computing an integer division and it might not reach 1.0 
         *To fix this we can simply add 1 to ((originalNum - num)) so ((originalNum - num) + 1.0). This ensures the numerators will reach each integer.
         */
    }

    // Method to process CLI arguments
    public static void processCLIArgs(String[] args) {
            double num1 = Double.parseDouble(args[0]);
            String operation = args[1];
            double num2 = args.length == 3 ? Double.parseDouble(args[2]) : 0;

            switch (operation) {
                case "+":
                    System.out.println("Result: " + add(num1, num2)); //prints addition
                    break;
                case "-":
                    System.out.println("Result: " + subtract(num1, num2));//prints subtraction
                    break;
                case "x":
                    System.out.println("Result: " + multiply(num1, num2));//prints multiplication
                    break;
                case "/":
                    try {
                        System.out.println("Result: " + divide(num1, num2));//prints division and makes sure second number isnt 0
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "!":
                    System.out.println("\nResult: " + factorial((int)num1));//computes factorial and turn num1 into an int
                    break;
            }
        }
 // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }
    }