package com.kodilla.good.patterns.challenges;

public class ItemOrderService implements OrderService {

    @Override
    public boolean order(User user, Item item, int quantity) {
        System.out.println("Ordered by: " + user.getName() + " " + user.getSurname() + "\n" +
                "Item ID: " + item.getItemID() + " item name: " + item.getItemName() + "\n" +
                "Order quantity: " + quantity + "\n");
        return true;
    }
}
