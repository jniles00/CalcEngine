package com.critical.runner;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        performCalculations();

//        Divider divider = new Divider();
//        doCalculation(divider, 100.d, 50.0d);
//
//        Adder adder = new Adder();
//        doCalculation(adder, 25.0d, 92.0d);

//        performMoreCalculations();

//        executeInteractively();
        dynamicInteractivity();
    }

    private static void dynamicInteractivity() {
        DynamicHelper helper = new DynamicHelper(new MathProcessing[]
        {  // Initialises DynamicHelper class to use Adder class to process users input
                new Adder(),
                new PowerOf()
        });

        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        helper.process(userInput);
    }

    // Gets input and information from user and breaks it into parts
    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    // Converts parts from Strings into proper data types and then performs the operation
    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());

//        char opCode = opCodeFromString((parts[0]));
//        if (opCode == 'w') {
//            handleWhen(parts);
//        } else {
//            double leftVal = valueFromWord(parts[1]);
//            double rightVal = valueFromWord(parts[2]);
////            double result = execute(opCode, leftVal, rightVal);
////            displayResult(opCode, leftVal, rightVal, result);
//        }
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = null;
        switch (operation) {
            case ADD:
                calculation = new Adder(leftVal, rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtracter(leftVal, rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal, rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal, rightVal);
                break;
        }
        return calculation;
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Divider(100.d, 50.d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
        };

        System.out.println("=".repeat(20));
        System.out.println("Array Calculations");

        for (CalculateBase calculation : calculations) {
            calculation.calculate();
            System.out.println("result = " + calculation.getResult());
        }
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.result);
        }
        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println("=".repeat(20));
        System.out.println("Overloading equation");

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overloaded results with ints: " + equationOverload.getResult());    // Java automatically converts to Double
    }


    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]); // Take string value then parse will translate the string into
        // an instance of local date and assign it to the variable
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays((daysToAdd));
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal,
                                      double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);

//        StringBuilder builder = new StringBuilder(20);
//        builder.append(leftVal);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(rightVal);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();

        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = 'l';
        for (int index = 0; index < opCodes.length; index++) {
            if (opCode == opCodes[index]) {
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0); // converts string representation of character to char representation of character
        double leftVar = Double.parseDouble(args[1]);  // converts sequence chars into a double
        double rightVar = Double.parseDouble(args[1]);
//        double result = execute(opCode, leftVar, rightVar);
//        System.out.println(result);
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        double value = -1d;

        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }

        if (value == -1.d) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}