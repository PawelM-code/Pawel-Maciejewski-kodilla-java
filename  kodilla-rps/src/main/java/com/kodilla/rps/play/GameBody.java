package com.kodilla.rps.play;

import java.util.Random;
import java.util.Scanner;

public class GameBody {
    private int roundCountPlayerOne = 0;
    private int roundCountPlayerTwo = 0;
    private Scanner scanner;
    private Random random;
    private final GameRules play;
    private boolean end = false;

    public GameBody(Scanner scanner, Random random, GameRules play) {
        this.scanner = scanner;
        this.random = random;
        this.play = play;
    }

    public void gameBody(String name){
        System.out.println("Enter the number of rounds won: ");
        int numberOfWonRounds = scanner.nextInt();

        System.out.println("key 1 - play \"stone\" \uD83D\uDC8E \n" +
                "key 2 - play \"paper\" \uD83E\uDDFB \n" +
                "key 3 - playing \"scissors\" \u2702 \n" +
                "key x - end game\n" +
                "key n - starting the game again");

        while (!end){
            System.out.println(name + " move: ");
            if(scanner.hasNextInt()){
                int playerOneMove = scanner.nextInt();
                int playerTwoMove = random.nextInt(3)+1;

                System.out.println("Computer move: " + playerTwoMove);
                int result = play.gameRules(playerOneMove,playerTwoMove);

                roundResultsMessages(name, playerOneMove, playerTwoMove, result);

                numberOfWonRounds = endOfTheGame(name, numberOfWonRounds);
            }else {
                String input = scanner.nextLine();
                numberOfWonRounds = confirmationEndOfTheGameOrEndOfTheCurrentGame(numberOfWonRounds, input);
            }
    }
}

    private int confirmationEndOfTheGameOrEndOfTheCurrentGame(int numberOfWonRounds, String input) {
        if(input.equals("x")){
            System.out.println("Are you sure you want to end the game? || Enter \"yes\" or \"no\"");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("yes")) {
                end = true;
            }
        } else if(input.equals("n")){
            System.out.println("Are you sure you want to end the current game? || Enter \"yes\" or \"no\"");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("yes")) numberOfWonRounds = initNumberOfWonRounds();
        }
        return numberOfWonRounds;
    }

    private void roundResultsMessages(String name, int playerOneMove, int playerTwoMove, int result) {
        if(result == playerOneMove){
            roundCountPlayerOne++;
            System.out.println(name + " won !\n" + name+" "+roundCountPlayerOne+" : "+roundCountPlayerTwo+" Computer");
        }else if(result == playerTwoMove) {
            roundCountPlayerTwo++;
            System.out.println("Computer won !\n"+ name+" " +roundCountPlayerOne+" : "+roundCountPlayerTwo+" Computer");
        }else if (playerOneMove == playerTwoMove){
            System.out.println("Tie.\n"+ name+" " +roundCountPlayerOne+" : "+roundCountPlayerTwo+" Computer");
        }else {
            System.out.println("Invalid number, please select key 1, 2 or 3.");
        }
    }

    private int endOfTheGame(String name, int numberOfWonRounds) {
        if(numberOfWonRounds == roundCountPlayerOne || numberOfWonRounds == roundCountPlayerTwo){
            if(roundCountPlayerOne>roundCountPlayerTwo){
                System.out.println(name + " WON Congratulations!\nEnd the game \"x\" or keep playing \"n\"");
            }else {
                System.out.println("Computer WON Congratulations!\nEnd the game \"x\" or keep playing \"n\"");
            }
            String xOrNPattern = "xn";
            String xOrN = scanner.next();

            while (!xOrNPattern.contains(xOrN)){
                System.out.println("Invalid character, please select again.");
                xOrN = scanner.next();
            }

            if (xOrN.equals("x")) {
                end = true;
            }else numberOfWonRounds = initNumberOfWonRounds();
        }
        return numberOfWonRounds;
    }

    private int initNumberOfWonRounds() {
        int numberOfWonRounds;
        System.out.println("Enter the number of rounds won: ");
        numberOfWonRounds = scanner.nextInt();
        roundCountPlayerOne = 0;
        roundCountPlayerTwo = 0;
        return numberOfWonRounds;
    }
}
