package com.kodilla.good.patterns.distribution;

public interface OrderProcessor {
    OrderDto process(final OrderRequest orderRequest);
}
