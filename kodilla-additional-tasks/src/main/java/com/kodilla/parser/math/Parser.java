package com.kodilla.parser.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    List<String> getInputStringAsComponentsList(String input) {
        String[] arraySplitedStringComponents = input.split("(?<=[-+*/])|(?=[-+*/])");
        List<String> listSplitedStringComponents = new ArrayList<>();
        Collections.addAll(listSplitedStringComponents, arraySplitedStringComponents);

        return listSplitedStringComponents;
    }

    double mathExpressionResult(List<String> componentOfMathExpression) {
        while (componentOfMathExpression.size() > 1) {
            if (componentOfMathExpression.contains("*") || componentOfMathExpression.contains("/")) {
                for (int i = 1; i < componentOfMathExpression.size(); i++) {
                    if (componentOfMathExpression.get(i).equals("*")) {
                        double result = Double.valueOf(componentOfMathExpression.get(i - 1)) * Double.valueOf(componentOfMathExpression.get(i + 1));
                        replaceMathOperationComponentsOnTheirResult(componentOfMathExpression, i, result);

                        return mathExpressionResult(componentOfMathExpression);
                    } else if (componentOfMathExpression.get(i).equals("/")) {
                        double result = Double.valueOf(componentOfMathExpression.get(i - 1)) / Double.valueOf(componentOfMathExpression.get(i + 1));
                        replaceMathOperationComponentsOnTheirResult(componentOfMathExpression, i, result);

                        return mathExpressionResult(componentOfMathExpression);
                    }
                }
            } else {
                for (int i = 1; i < componentOfMathExpression.size(); i++) {
                    if (componentOfMathExpression.get(i).equals("+")) {
                        double result = Double.valueOf(componentOfMathExpression.get(i - 1)) + Double.valueOf(componentOfMathExpression.get(i + 1));
                        replaceMathOperationComponentsOnTheirResult(componentOfMathExpression, i, result);

                        return mathExpressionResult(componentOfMathExpression);
                    } else if (componentOfMathExpression.get(i).equals("-")) {
                        double result = Double.valueOf(componentOfMathExpression.get(i - 1)) - Double.valueOf(componentOfMathExpression.get(i + 1));
                        replaceMathOperationComponentsOnTheirResult(componentOfMathExpression, i, result);

                        return mathExpressionResult(componentOfMathExpression);
                    }
                }
            }
        }
        return Double.valueOf(componentOfMathExpression.get(0));
    }

    private void replaceMathOperationComponentsOnTheirResult(List<String> componentOfMathExpression, int i, double result) {
        componentOfMathExpression.remove(i + 1);
        componentOfMathExpression.remove(i);
        componentOfMathExpression.add(i, String.valueOf(result));
        componentOfMathExpression.remove(i - 1);
    }
}
