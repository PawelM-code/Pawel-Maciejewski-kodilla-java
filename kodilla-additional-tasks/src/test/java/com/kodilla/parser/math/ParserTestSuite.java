package com.kodilla.parser.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ParserTestSuite {
    @Test
    public void testMathExpressionResult(){
        //Given
        ExpressionComponents expressionComponentsOne = new ExpressionComponents("2-5*5+2/2");
        List<String> mathComponentsListOne = expressionComponentsOne.getInputStringAsComponentsList();

        ExpressionComponents expressionComponentsTwo = new ExpressionComponents("10+16-2*4");
        List<String> mathComponentsListTwo = expressionComponentsTwo.getInputStringAsComponentsList();
        Parser parser = new Parser();

        //When
        double resultOne = parser.mathExpressionResult(mathComponentsListOne);
        double resultTwo = parser.mathExpressionResult(mathComponentsListTwo);

        //Then
        Assert.assertEquals(-22,resultOne,0);
        Assert.assertEquals(18,resultTwo,0);
    }
}
