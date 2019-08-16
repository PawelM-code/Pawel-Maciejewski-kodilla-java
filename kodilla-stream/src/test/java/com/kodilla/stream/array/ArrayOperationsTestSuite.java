package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite implements ArrayOperations {
    @Test
    public void testGetAverage(){
        int[] testArray = {10,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        Assert.assertEquals(OptionalDouble.of(10.95), ArrayOperations.getAverage(testArray));
    }
}
