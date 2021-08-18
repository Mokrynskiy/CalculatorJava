package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputFormateExeption{
        String selectedAction = "";
        while (!"2".equals(selectedAction))
        {
            selectedAction = "";
            System.out.println("Введите математическую операцию в формате: [1 операнд]побел[оператор +,-,*,/]пробел[2 операнд]. Либо арабские либо римские цифры положительные не больше 10(X).");
            Scanner reader = new Scanner(System.in);
            String operation = reader.nextLine();
            System.out.println("Результат операции: "+ Calculator.Calculate(operation));
            System.out.println("");
            while (!"1".equals(selectedAction)&&!"2".equals(selectedAction))
            {
                System.out.println("Выберите дальнейшее действие:");
                System.out.println("1. Для продолжения введите - 1.");
                System.out.println("2. Для завершения введите - 2.");
                selectedAction = reader.nextLine();
            }
        }
    }
}
