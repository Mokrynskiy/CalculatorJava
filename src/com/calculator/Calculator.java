package com.calculator;

public class Calculator {
    static int firstOperand = 0;
    static  int secondOperand = 0;
    static String operator = "";
    static  String result = "";
    static String Calculate(String operation) throws InputFormateExeption {
        if (Validator.ValidateMathOperation(operation))
        {
            firstOperand = Validator.firstOperand;
            secondOperand = Validator.secondOperand;
            operator = Validator.operator;
            switch (operator)
            {
                case "+":
                    result = String.valueOf(firstOperand+secondOperand);
                    break;
                case "-":
                    result = String.valueOf(firstOperand-secondOperand);
                    break;
                case "*":
                    result = String.valueOf(firstOperand*secondOperand);
                    break;
                case "/":
                    result = String.valueOf(firstOperand/secondOperand);
                    break;
            }
            if (Validator.isRomanNambersOperation)
            {
                result = ArabicRomanConvertor.ArabicToRoman(Integer.parseInt(result));
            }
        }
        return result;
    }
}
