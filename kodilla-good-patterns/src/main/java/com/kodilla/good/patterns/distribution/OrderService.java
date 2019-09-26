package com.kodilla.good.patterns.distribution;

public interface OrderService {
    boolean order(final Supplier supplier, final ProductType productType, final int quantity);
}
