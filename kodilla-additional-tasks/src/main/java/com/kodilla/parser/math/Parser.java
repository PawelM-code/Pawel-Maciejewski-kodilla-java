package com.kodilla.parser.math;

import java.util.List;

class Parser {
    double mathExpressionResult(List<String> componentsOfMathExpression) {
        while (componentsOfMathExpression.size() > 1) {
            if (componentsOfMathExpression.contains("*") || componentsOfMathExpression.contains("/")) {
                for (int i = 1; i < componentsOfMathExpression.size(); i++) {
                    if (multiplyOrDivide(componentsOfMathExpression, i))
                        return mathExpressionResult(componentsOfMathExpression);
                }
            } else {
                for (int i = 1; i < componentsOfMathExpression.size(); i++) {
                    if (sumOrSubtract(componentsOfMathExpression, i))
                        return mathExpressionResult(componentsOfMathExpression);
                }
            }
        }
        return getDouble(componentsOfMathExpression, 0);
    }

    private boolean sumOrSubtract(List<String> componentsOfMathExpression, int i) {
        if (componentsOfMathExpression.get(i).equals("+")) {
            double result = sum(componentsOfMathExpression, i);
            replaceMathOperationComponentsOnTheirResult(componentsOfMathExpression, i, result);

            return true;
        } else if (componentsOfMathExpression.get(i).equals("-")) {
            double result = subtract(componentsOfMathExpression, i);
            replaceMathOperationComponentsOnTheirResult(componentsOfMathExpression, i, result);

            return true;
        }
        return false;
    }

    private boolean multiplyOrDivide(List<String> componentsOfMathExpression, int i) {
        if (componentsOfMathExpression.get(i).equals("*")) {
            double result = multiply(componentsOfMathExpression, i);
            replaceMathOperationComponentsOnTheirResult(componentsOfMathExpression, i, result);

            return true;
        } else if (componentsOfMathExpression.get(i).equals("/")) {
            double result = divide(componentsOfMathExpression, i);
            replaceMathOperationComponentsOnTheirResult(componentsOfMathExpression, i, result);

            return true;
        }
        return false;
    }

    private double divide(List<String> componentsOfMathExpression, int i) {
        return getDouble(componentsOfMathExpression, i - 1) / getDouble(componentsOfMathExpression, i + 1);
    }

    private double multiply(List<String> componentsOfMathExpression, int i) {
        return getDouble(componentsOfMathExpression, i - 1) * getDouble(componentsOfMathExpression, i + 1);
    }

    private double subtract(List<String> componentsOfMathExpression, int i) {
        return getDouble(componentsOfMathExpression, i - 1) - getDouble(componentsOfMathExpression, i + 1);
    }

    private double sum(List<String> componentsOfMathExpression, int i) {
        return getDouble(componentsOfMathExpression, i - 1) + getDouble(componentsOfMathExpression, i + 1);
    }

    private Double getDouble(List<String> componentsOfMathExpression, int index) {
        return Double.valueOf(componentsOfMathExpression.get(index));
    }

    private void replaceMathOperationComponentsOnTheirResult(List<String> componentOfMathExpression, int i, double result) {
        componentOfMathExpression.remove(i + 1);
        componentOfMathExpression.remove(i);
        componentOfMathExpression.add(i, String.valueOf(result));
        componentOfMathExpression.remove(i - 1);
    }
}
