package com.serenitydojo.calculator;

public class Calculator {
    public int evaluate(String expression) throws IllegalMathsOperatorException {
        if (expression.equals("")) {
            return 0;
        } else {
            String[] numbers = expression.split("\\D+");
            String[] operators = expression.split("[0-9]+");
            int result = Integer.parseInt(numbers[0].trim());
            for (int i = 1; i < numbers.length; i++) {
                switch (operators[i].trim()) {
                    case "+":
                        result += getIntegerFromString(numbers[i]);
                        break;
                    case "-":
                        result -= getIntegerFromString(numbers[i]);
                        break;
                    case "*":
                        result *= getIntegerFromString(numbers[i]);
                        break;
                    case "/":
                        result /= getIntegerFromString(numbers[i]);
                        break;
                    default:
                        throw new IllegalMathsOperatorException(String.format("%s operator can't be used here", operators[i].trim()));
                }
            }
            return result;
        }
    }

    public int getIntegerFromString(String string) {
        return Integer.parseInt(string.trim());
    }
}