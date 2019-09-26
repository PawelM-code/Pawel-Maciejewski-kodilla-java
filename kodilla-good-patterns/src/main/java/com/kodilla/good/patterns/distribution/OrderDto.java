package com.kodilla.good.patterns.distribution;

public class OrderDto {
    private ProductType productType;
    private int quantity;
    private boolean isConfirmed;

    OrderDto(ProductType productType, int quantity, boolean isConfirmed) {
        this.productType = productType;
        this.quantity = quantity;
        this.isConfirmed = isConfirmed;
    }

    ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    boolean isConfirmed() {
        return isConfirmed;
    }
}
