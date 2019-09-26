package com.kodilla.good.patterns.distribution;

public class ShopInformationService implements InformationService {

    @Override
    public void inform(OrderDto orderDto) {
        if (orderDto.isConfirmed()) {
            System.out.println("Order completed. Product name: " + orderDto.getProductType().getProductName() + ". Quantity: " + orderDto.getQuantity() + ".\n");
        } else {
            System.out.println("Order rejected.Product name: " + orderDto.getProductType().getProductName() + ". Quantity: " + orderDto.getQuantity() + ".\n");
        }
    }
}
