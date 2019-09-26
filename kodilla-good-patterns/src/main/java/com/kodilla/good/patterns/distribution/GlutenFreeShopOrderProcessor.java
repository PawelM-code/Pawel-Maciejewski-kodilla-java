package com.kodilla.good.patterns.distribution;

public class GlutenFreeShopOrderProcessor implements OrderProcessor {
    private OrderService orderService;
    private OrderRepository orderRepository;

    GlutenFreeShopOrderProcessor(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getSupplier(), orderRequest.getProductType(), orderRequest.getQuantity());
        boolean isCreateOrder = orderRepository.createOrder(orderRequest.getSupplier(), orderRequest.getProductType(), orderRequest.getQuantity());

        if (isOrdered && isCreateOrder) {
            if (orderRequest.getProductType().getProductClass() == 'A') {
                return new OrderDto(orderRequest.getProductType(), orderRequest.getQuantity(), true);
            } else {
                return new OrderDto(orderRequest.getProductType(), orderRequest.getQuantity(), false);
            }
        } else {
            return new OrderDto(orderRequest.getProductType(), orderRequest.getQuantity(), false);
        }
    }
}
