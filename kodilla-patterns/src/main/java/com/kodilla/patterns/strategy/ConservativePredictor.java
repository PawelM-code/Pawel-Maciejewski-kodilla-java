package com.kodilla.patterns.strategy;

public class ConservativePredictor implements BuyPredictor {
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
