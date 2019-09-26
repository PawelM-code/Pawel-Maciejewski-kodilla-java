package com.kodilla.good.patterns.distribution;

class OrderRequestRetriever {
    private OrderRequest orderRequest1;
    private OrderRequest orderRequest2;
    private OrderRequest orderRequest3;

    OrderRequest getOrderRequest1() {
        return orderRequest1;
    }

    OrderRequest getOrderRequest2() {
        return orderRequest2;
    }

    OrderRequest getOrderRequest3() {
        return orderRequest3;
    }

    OrderRequestRetriever retrive() {
        Supplier extraFoodShop = new Supplier("ExtraFoodShop", "ExtraFoodShop@ExtraFoodShop.pl");
        Supplier healthyShop = new Supplier("HealthyShop", "healthyShop@healthyShop.pl");
        Supplier glutenFreeShop = new Supplier("GlutenFreeShop", "glutenFreeShop@glutenFreeShop.pl");
        ProductType productType1 = new ProductType("Marchewka", 'A');
        ProductType productType2 = new ProductType("Piertruszka", 'B');
        ProductType productType3 = new ProductType("Seler", 'A');

        orderRequest1 = new OrderRequest(extraFoodShop, productType1, 100);
        orderRequest2 = new OrderRequest(healthyShop, productType2, 50);
        orderRequest3 = new OrderRequest(glutenFreeShop, productType3, 20);
        return this;
    }
}
