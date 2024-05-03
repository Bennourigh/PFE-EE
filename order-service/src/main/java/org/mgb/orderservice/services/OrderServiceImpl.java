package org.mgb.orderservice.services;

import lombok.AllArgsConstructor;
import org.mgb.orderservice.DTOs.*;
import org.mgb.orderservice.Rabbit.RabbitProducer;
import org.mgb.orderservice.entities.CartItem;
import org.mgb.orderservice.entities.Order;
import org.mgb.orderservice.enums.OrderStatus;
import org.mgb.orderservice.mappers.ClientMapper;
import org.mgb.orderservice.mappers.OrderMapper;
import org.mgb.orderservice.repository.CartItemRepository;
import org.mgb.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Transactional
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private CartItemRepository cartItemRepository;
    private OrderRepository orderRepository;
    private RabbitProducer RabbitProducer;
    private InventoryRestClientService inventoryRestClientService;
    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
        orderRepository.flush();
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.orderMapper(orderDTO);
        orderRepository.saveAndFlush(order);
        //handel the rest of the business logic
    }

    @Override
    public void updateCartItems(UUID orderId, List<CartItemDTO> orderItems) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        // Clear existing items to replace them, or implement logic to update existing items
        List<CartItem> list=orderRepository.findOrderItems(orderId);
        list.clear();
        for (CartItemDTO cartItemDTO : orderItems) {
            CartItem cartItem = OrderMapper.INSTANCE.orderMapper(cartItemDTO);

            list.add(cartItem);
        }

        // Save the order, cascading saves to cart items
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void updateStatus(UpdateOrderStatusDTO updateStatus) {
        Order order = orderRepository.findById(updateStatus.getOrderId()).get();
        order.setStatus(updateStatus.getStatus());
        orderRepository.saveAndFlush(order);
        //handel the rest of the business logic
        if (updateStatus.getStatus() == OrderStatus.PENDING) {
            for (CartItem cartItem : order.getOrderItems()) {
                UpdateProductReservedDTO updateProductReserved = new UpdateProductReservedDTO();
                updateProductReserved.setId(cartItem.getProductId());
                updateProductReserved.setQuantity(cartItem.getQuantity());
                updateProductReserved.setPrice(cartItem.getPrice());
                RabbitProducer.send(updateProductReserved);
            }
        }
    }

    @Override
    public OrderCompleteDTO getOrderById(UUID id) {
    Order order = orderRepository.findById(id).get();
    return ClientMapper.INSTANCE.clientMapper(order);
    }
    @Override
    public List<OrderDTO> getOrders() {
        List<Order> orders=orderRepository.findAll();
        return orders.stream().map(OrderMapper.INSTANCE::orderMapper).collect(Collectors.toList());
    }
    @Override
    public void deleteOrderItem(UUID id) {
        cartItemRepository.deleteById(id);
    }
}
