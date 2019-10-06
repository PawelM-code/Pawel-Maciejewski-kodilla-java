package com.kodilla.parser.math;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        System.out.println("Enter math expression: ");
        String mathExpression = scanner.nextLine();

        ExpressionComponents expressionComponents = new ExpressionComponents(mathExpression);
        List<String> mathExpressionComponents = expressionComponents.getInputStringAsComponentsList();

        double result = parser.mathExpressionResult(mathExpressionComponents);
        System.out.println(result);
    }
}
