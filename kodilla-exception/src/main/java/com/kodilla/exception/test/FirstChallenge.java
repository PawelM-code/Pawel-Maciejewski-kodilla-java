package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0;
        int count = 0;

        try{
            result = firstChallenge.divide(3, 0);
        }catch (ArithmeticException e){
            System.out.println("Exception: " + e);
            count++;
        }finally {
            System.out.println("Finally test");
        }

        if(count != 1) System.out.println(result);
    }
}