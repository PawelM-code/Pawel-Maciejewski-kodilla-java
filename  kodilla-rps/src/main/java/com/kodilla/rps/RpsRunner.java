package com.kodilla.rps;

import com.kodilla.rps.play.GameBody;
import com.kodilla.rps.play.GameRules;


import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args){
        GameRules play = new GameRules();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        GameBody gameBody = new GameBody(scanner,random,play);

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        gameBody.gameBody(name);
    }
}