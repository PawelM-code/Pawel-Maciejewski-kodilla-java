package com.kodilla.parser.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExpressionComponents {
    private String mathExpression;

    ExpressionComponents(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    List<String> getInputStringAsComponentsList() {
        String[] inputAsComponentsArray = mathExpression.split("(?<=[-+*/])|(?=[-+*/])");
        List<String> inputAsComponentsList = new ArrayList<>();
        Collections.addAll(inputAsComponentsList, inputAsComponentsArray);

        return inputAsComponentsList;
    }
}
