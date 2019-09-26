package com.kodilla.good.patterns.distribution;

public class OrderRequest {
    private Supplier supplier;
    private ProductType productType;
    private int Quantity;

    public OrderRequest(Supplier supplier, ProductType productType, int quantity) {
        this.supplier = supplier;
        this.productType = productType;
        Quantity = quantity;
    }

    Supplier getSupplier() {
        return supplier;
    }

    ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return Quantity;
    }
}
