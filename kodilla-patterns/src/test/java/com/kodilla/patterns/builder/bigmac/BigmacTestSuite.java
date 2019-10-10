package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sesame bun")
                .burgers(2)
                .ingredient("Tomato")
                .sauce("Spicy")
                .ingredient("Lettuce")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyburgers = bigmac.getBurgers();
        String souce = bigmac.getSauce();
        String bun = bigmac.getBun();
        //Then
        Assert.assertEquals(2, howManyIngredients);
        Assert.assertEquals(2, howManyburgers);
        Assert.assertEquals("Sesame bun", bun);
        Assert.assertEquals("Spicy", souce);
    }
}

