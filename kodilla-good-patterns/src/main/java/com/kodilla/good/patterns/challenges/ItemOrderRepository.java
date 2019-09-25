package com.kodilla.good.patterns.challenges;

public class ItemOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder(User user, Item item, int quantity) {
        System.out.println("Create order: " + user.getName() + " " + user.getSurname() + "\n" +
                "Item ID: " + item.getItemID() + " item name: " + item.getItemName() + "\n" +
                "Order quantity: " + quantity + "\n");
        return true;
    }
}
