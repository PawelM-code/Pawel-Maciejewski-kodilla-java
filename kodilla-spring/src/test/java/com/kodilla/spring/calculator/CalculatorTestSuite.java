package com.kodilla.spring.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double add = calculator.add(2, 2);
        double sub = calculator.sub(4, 4);
        double mul = calculator.mul(5, 2);
        double div = calculator.div(10, 5);
        //Then
        assertEquals(4, add,0);
        assertEquals(0, sub,0);
        assertEquals(10, mul,0);
        assertEquals(2, div,0);
    }
}
