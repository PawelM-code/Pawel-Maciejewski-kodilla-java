package com.kodilla.rps;

import com.kodilla.rps.play.GameBody;
import com.kodilla.rps.play.GameRules;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class RpsRunnerTestSuite {
    @Test
    public void testCheckWinScore(){
        GameRules play = new GameRules();

        int result1 = play.gameRules(1,1); //tie
        int result2 = play.gameRules(1,2); //b
        int result3 = play.gameRules(1,3); //a
        int result4 = play.gameRules(3,1); //b
        int result5 = play.gameRules(2,1); //a
        int result6 = play.gameRules(2,3); //b
        int result7 = play.gameRules(3,2); //a

        Assert.assertEquals(0, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(1, result3);
        Assert.assertEquals(1, result4);
        Assert.assertEquals(2, result5);
        Assert.assertEquals(3, result6);
        Assert.assertEquals(3, result7);
    }
}
