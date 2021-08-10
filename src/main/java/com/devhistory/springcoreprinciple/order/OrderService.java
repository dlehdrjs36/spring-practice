package com.devhistory.springcoreprinciple.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
