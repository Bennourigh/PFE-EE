package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.*;
import org.mgb.orderservice.enums.OrderStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface OrderService {
    @Transactional
    void deleteOrder(UUID id);
    void updateOrder(OrderDTO orderDTO);
    void updateCartItems(UUID orderId, List<CartItemDTO> orderItems);
    @Transactional
    void updateStatus(UpdateOrderStatusDTO updateStatus);
    @Transactional
    OrderCompleteDTO getOrderById(UUID id);
    @Transactional
    List<OrderDTO> getOrders();

    @Transactional
    void deleteOrderItem(UUID id);
}
