package com.kodilla.good.patterns.challenges;

public interface OrderService {
    boolean order(final User user, final Item item, final int quantity);
}
