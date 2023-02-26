package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public int evaluate(String expression) throws IllegalMathsOperatorException {
        if (expression.equals("")) {
            return 0;
        }

        String[] tokens = expression.split(" ");

        int result = 0;
        String operator = "+";

        for (String token : tokens) {
            if (!StringUtils.isNumeric(token)) {
                operator = token;
            } else {
                result = process(result, operator, token);
            }
        }
        return result;
    }

    public int process(int firstOperand, String operator, String secondOperand) throws IllegalMathsOperatorException {
        switch (operator) {
            case "+":
                firstOperand += Integer.parseInt(secondOperand);
                break;
            case "-":
                firstOperand -= Integer.parseInt(secondOperand);
                break;
            case "*":
                firstOperand *= Integer.parseInt(secondOperand);
                break;
            case "/":
                firstOperand /= Integer.parseInt(secondOperand);
                break;
            default:
                throw new IllegalMathsOperatorException(String.format("%s operator can't be used here", operator));
        }
        return firstOperand;
    }
}