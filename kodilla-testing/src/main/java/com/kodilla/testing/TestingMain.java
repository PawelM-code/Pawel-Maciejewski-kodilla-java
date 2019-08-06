package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
//        SimpleUser simpleUser = new SimpleUser("theForumUser");
//
//        String result = simpleUser.getUserName();
//
//        if (result.equals("theForumUser")){
//            System.out.println("test OK");
//        } else {
//            System.out.println("Error!");
//        }
        Calculator calculator = new Calculator(2,2);

        int resultAdd = calculator.getA() + calculator.getB();
        int resultSubtract = calculator.getA() - calculator.getB();

        System.out.println("Add:");
        if(resultAdd == calculator.add(2,2)){
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

        System.out.println("Subtract:");
        if(resultSubtract == calculator.subtract(2,2)){
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

    }
}