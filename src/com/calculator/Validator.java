package com.calculator;

import java.util.regex.Pattern;

public class Validator {
    static String arabicPattern = "^[-]?\\d+\\s[*/+-]\\s[-]?\\d+$";
    static String romanPattern = "^M{0,3}(CM|CD|D?C{0,3})?(XC|XL|L?X{0,3})?(IX|IV|V?I{0,3})?\\s[*/+-]\\sM{0,3}(CM|CD|D?C{0,3})?(XC|XL|L?X{0,3})?(IX|IV|V?I{0,3})?$";
    static boolean valid = false;
    static int firstOperand = 0;
    static int secondOperand = 0;
    static String operator = "";
    static boolean isRomanNambersOperation = false;
    static boolean ValidateMathOperation(String operationString) throws InputFormateExeption
    {
        try
        {
            if (Pattern.matches(arabicPattern, operationString)||Pattern.matches(romanPattern, operationString))
            {
                String[] operationMembers = operationString.split(" ");
                operator = operationMembers[1];
                if(Pattern.matches(romanPattern, operationString))
                {
                    isRomanNambersOperation = true;
                    firstOperand = ArabicRomanConvertor.RomanToArabic(operationMembers[0]);
                    secondOperand = ArabicRomanConvertor.RomanToArabic(operationMembers[2]);
                    if ("-".equals(operator) && firstOperand <= secondOperand)
                    {
                        throw new InputFormateExeption("Римские цифры не могут быть отрицательными иля равнятся 0");
                    }
                }
                else
                {
                    firstOperand = Integer.parseInt(operationMembers[0]);
                    secondOperand = Integer.parseInt(operationMembers[2]);
                }

                if (firstOperand>10 || secondOperand>10)
                {
                    throw new InputFormateExeption("Значения операндов не должны быть больше 10.");
                }
                if (firstOperand<0 || secondOperand<0)
                {
                    throw new InputFormateExeption("Значения операндов не должны быть больше отрецательными.");
                }
                if ("/".equals(operator) && secondOperand  == 0)
                {
                    throw new InputFormateExeption("Деление на ноль.");
                }
                valid = true;
            }
            else
            {
                valid = false;
                throw new InputFormateExeption("Неверный формат входных данных");
            }
        }
        catch (InputFormateExeption e)
        {
            throw new InputFormateExeption("Ошибка ввода данных. " +e.getMessage());
        }
        return valid;
    }
}
