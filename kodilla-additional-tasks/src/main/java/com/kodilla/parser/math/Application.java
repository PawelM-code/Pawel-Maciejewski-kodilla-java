package com.kodilla.parser.math;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        String input = scanner.nextLine();

        double result = parser.mathExpressionResult(parser.getInputStringAsComponentsList(input));
        System.out.println(result);
    }
}
