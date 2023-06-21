package org.example;
import java.util.Stack;
import java.util.Scanner;

public class Main {

//Перевірка дужок
            public static boolean parentheses(String equation) {
                Stack<Character> stack = new Stack<>();
                for (char c : equation.toCharArray()) {
                    if (c == '(') {
                        stack.push(c);
                    } else if (c == ')') {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            return false;
                        }
                    }
                }
                return stack.isEmpty();
            }
// Перевірка коректності введеного виразу
            public static boolean expression(String equation) {
                for (int i = 0; i < equation.length() - 1; i++) {
                    char currentChar = equation.charAt(i);
                    char nextChar = equation.charAt(i + 1);
                    if (isMathOperator(currentChar) && isMathOperator(nextChar)) {
                        return false;
                    }
                }
                return true;
            }
//Перевірка, чи є переданий символ математичним оператором
            private static boolean isMathOperator(char c) {
                return c == '+' || c == '-' || c == '*' || c == '/';
            }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a math equation: ");
        String equation = scanner.nextLine();
// Перевірка на наявність рівняння
        while (equation.isEmpty()) {
            System.out.print("Enter a math equation: ");
            equation = scanner.nextLine();

            if (equation.isEmpty()) {
                System.out.println("Please try again. The equation cannot be empty.");
            }
        }
//Перевірка на правильність написання
        if (parentheses(equation) && expression(equation)) {
            System.out.println("The equation is valid.");
        } else {
            System.out.println("The equation is invalid.");
        }
        //Умова виведення у компіляторі кількості чисел
        if (parentheses(equation) && expression(equation)) {
            int numCount = countNumbers(equation);

            System.out.println("Number count: " + numCount);
        }

    }
//Порахувати кількість чисел у рівнянні, введеному користувачем.
    public static int countNumbers(String equation) {
        String[] numbers = equation.split("[^0-9.]+");
        return numbers.length;
    }


}



