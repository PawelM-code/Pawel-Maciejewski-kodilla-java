package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    private ArrayList<Integer> oddNumbers;

    public OddNumbersExterminator(ArrayList<Integer> oddNumbers){
        this.oddNumbers = oddNumbers;
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }
}
