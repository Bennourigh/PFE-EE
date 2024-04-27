package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.CartItemDTO;
import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.DTOs.UpdateOrderStatusDTO;
import org.mgb.orderservice.enums.OrderStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    @Transactional
    OrderDTO addOrder(OrderDTO orderDTO);

    @Transactional
    void deleteOrder(UUID id);

    @Transactional
    void updateOrder(OrderDTO orderDTO);
    @Transactional
    OrderDTO getOrderById(UUID id);
    @Transactional
    List<OrderDTO> getOrders();
    @Transactional
    void updateOrderItem(CartItemDTO cartItemDTO);
    @Transactional

    void deleteOrderItem(UUID id);
}
