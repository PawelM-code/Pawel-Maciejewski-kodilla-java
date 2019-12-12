package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaWithHamExtraCheeseOnionGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        String orderDescription = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals("Order Margherita + ham + extra cheese + onion", orderDescription);
    }

    @Test
    public void testPizzaWithHamExtraCheeseOnionGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(25), calculatedCost);
    }
}
