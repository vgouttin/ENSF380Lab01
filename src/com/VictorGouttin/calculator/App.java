package com.VictorGouttin.calculator;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    while (true) {
	        System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
	        String operation = scanner.next();
	        
	        if (operation.equalsIgnoreCase("exit")) {
	            System.out.println("Exiting calculator...");
	            break;
	        }

	        // For operations requiring two inputs
	        if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
	            System.out.print("Enter first number: ");
	            double num1 = scanner.nextDouble();
	            System.out.print("Enter second number: ");
	            double num2 = scanner.nextDouble();

	            switch (operation.toLowerCase()) {
	                case "add":
	                    System.out.println("Result: " + add(num1, num2));
	                    break;
	                case "subtract":
	                    System.out.println("Result: " + subtract(num1, num2));
	                    break;
	                case "multiply":
	                    System.out.println("Result: " + multiply(num1, num2));
	                    break;
	                case "divide":
	                    System.out.println("Result: " + divide(num1, num2));
	                    break;
	                case "pow":
	                    System.out.println("Result: " + power(num1, num2));
	                    break;
	                case "permutation":
	                	System.out.println("Result: " + permutations((int)num1, (int)num2));
	                	break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        } else {
	            // For operations requiring one input
	            System.out.print("Enter number: ");
	            double num = scanner.nextDouble();

	            switch (operation.toLowerCase()) {
	                case "sqrt":
	                    System.out.println("Result: " + sqrt(num));
	                    break;
	                case "log":
	                    System.out.println("Result: " + log(num));
	                    break;
	                case "log10":
	                    System.out.println("Result: " + log10(num));
	                    break;
	                case "sin":
	                    System.out.println("Result: " + sin(num));
	                    break;
	                case "cos":
	                    System.out.println("Result: " + cos(num));
	                    break;
	                case "tan":
	                    System.out.println("Result: " + tan(num));
	                    break;
	                case "factorial":
	                    // Factorial is a special case requiring an integer
	                    System.out.println("\nResult: " + factorial((int)num));
	                    break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        }
	    }
	    
	    scanner.close();
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
        return Math.sin(Math.toRadians(angleRadians));
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(Math.toRadians(angleRadians));
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(Math.toRadians(angleRadians));// Recursive method to calculate permutations without replacement
    }
    public static long permutations(int n, int k) {
           // Error checking
            if (k < 0 || k > 100) {
                System.out.println("Error: Number of selected items must be between 0 and 100.");
                return 0;
            }
            if (n < 0) {
                System.out.println("Error: Total number of elements cannot be negative.");
                return 0;
            }
            if (k > n) {
                System.out.println("Error: Number of selected items cannot exceed total number of elements.");
                return 0;
            }
            
            // Base case for recursion
            if (k == 0) {
                return 1;
            }
            
            // Recursive calculation
            return n * permutations(n - 1, k - 1);
           
            /*my alternative solution is this but I ran out of time and didnt test it...
             *for (int i = 0; i < k; i++) {
        	 *result *= (n - i);
        	 *}
        	 *return result; 
        	*/
    }
    
}
