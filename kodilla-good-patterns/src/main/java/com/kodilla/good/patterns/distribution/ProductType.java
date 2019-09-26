package com.kodilla.good.patterns.distribution;

class ProductType {
    private String productName;
    private char productClass;

    ProductType(String productName, char productClass) {
        this.productName = productName;
        this.productClass = productClass;
    }

    String getProductName() {
        return productName;
    }

    char getProductClass() {
        return productClass;
    }
}
