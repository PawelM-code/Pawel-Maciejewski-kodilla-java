package com.kodilla.good.patterns.distribution;

public interface OrderRepository {
    boolean createOrder(Supplier supplier, ProductType productType, int quantity);
}
