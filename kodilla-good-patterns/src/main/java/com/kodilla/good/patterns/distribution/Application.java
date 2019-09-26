package com.kodilla.good.patterns.distribution;

public class Application {
    public static void main(String[] args) {
        ShopInformationService shopInformationService = new ShopInformationService();
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest1 = orderRequestRetriever.retrive().getOrderRequest1();
        OrderRequest orderRequest2 = orderRequestRetriever.retrive().getOrderRequest2();
        OrderRequest orderRequest3 = orderRequestRetriever.retrive().getOrderRequest3();

        ExtraFoodShopOrderProcessor extraFoodShopOrderProcessor = new ExtraFoodShopOrderProcessor(
                new ShopOrderService(), new ShopOrderRepository());
        shopInformationService.inform(extraFoodShopOrderProcessor.process(orderRequest1));

        HealthyShopOrderProcessor healthyShopOrderProcessor = new HealthyShopOrderProcessor(
                new ShopOrderService(), new ShopOrderRepository());
        shopInformationService.inform(healthyShopOrderProcessor.process(orderRequest2));

        GlutenFreeShopOrderProcessor glutenFreeShopOrderProcessor = new GlutenFreeShopOrderProcessor(
                new ShopOrderService(), new ShopOrderRepository());
        shopInformationService.inform(glutenFreeShopOrderProcessor.process(orderRequest3));
    }
}
