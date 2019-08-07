package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;
import java.util.ArrayList;

public class CollectionTestSuite {
    @Rule public TestName testName = new TestName();
    @Before
    public void before(){
        System.out.println("Begin: " + testName.getMethodName());
    }
    @After
    public void after(){
        System.out.println("End: " + testName.getMethodName());
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        ArrayList<Integer> withoutOdd = new ArrayList<>();
        withoutOdd.add(1);
        withoutOdd.add(3);
        withoutOdd.add(5);

        OddNumbersExterminator numberList = new OddNumbersExterminator(new ArrayList<>());
        ArrayList<Integer> result = numberList.exterminate(withoutOdd);

        Assert.assertEquals(result.size(),0);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(3);
        normalList.add(4);
        normalList.add(5);
        normalList.add(6);
        normalList.add(7);

        OddNumbersExterminator numberList = new OddNumbersExterminator(new ArrayList<>());
        ArrayList<Integer> result = numberList.exterminate(normalList);

        Assert.assertEquals(result.size(),3);
    }
}
