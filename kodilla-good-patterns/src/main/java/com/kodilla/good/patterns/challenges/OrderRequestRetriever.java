package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    public OrderRequest retrive() {
        User user = new User("Jan", "Nowak");
        Item item = new Item(1, "Puzzle 15 pcs");
        int quantity = 2;

        return new OrderRequest(user, item, quantity);
    }
}
