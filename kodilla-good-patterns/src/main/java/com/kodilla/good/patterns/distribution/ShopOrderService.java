package com.kodilla.good.patterns.distribution;

public class ShopOrderService implements OrderService{

    @Override
    public boolean order(Supplier supplier, ProductType productType, int quantity) {
        System.out.println("Order: " + supplier.getName() + " " + supplier.getMail() + " | "
                + productType.getProductName() + " " + productType.getProductClass() + " | "
                + quantity);
        return true;
    }
}
