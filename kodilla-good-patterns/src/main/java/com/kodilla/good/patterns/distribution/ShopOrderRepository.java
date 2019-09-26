package com.kodilla.good.patterns.distribution;

public class ShopOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder(Supplier supplier, ProductType productType, int quantity) {
        System.out.println("Create order: " + supplier.getName() + " " + supplier.getMail() + " | "
                + productType.getProductName() + " " + productType.getProductClass() + " | "
                + quantity);
        return true;
    }
}
