package com.kodilla.rps.play;

public class GameRules {
    public int gameRules(int a, int b){
        if(a == 1 && b == 2) return b;
        else if(a == 2 && b == 1) return a;
        else if(a == 1 && b == 3) return a;
        else if(a == 3 && b == 1) return b;
        else if (a == 2 && b == 3) return b;
        else if (a == 3 && b == 2) return a;
        else return 0;
    }
}
