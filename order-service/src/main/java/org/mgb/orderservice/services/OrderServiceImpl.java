package org.mgb.orderservice.services;

import lombok.AllArgsConstructor;
import org.mgb.orderservice.DTOs.CartItemDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;
import org.mgb.orderservice.mappers.OrderMapper;
import org.mgb.orderservice.repository.CartItemRepository;
import org.mgb.orderservice.repository.ClientRepository;
import org.mgb.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private CartItemRepository cartItemRepository;
    private OrderRepository orderRepository;

    private InventoryRestClientService inventoryRestClientService;
    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.orderMapper(orderDTO);
        Order savedorder = orderRepository.save(order);
        return OrderMapper.INSTANCE.orderMapper(savedorder);
    }



    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.orderMapper(orderDTO);
        orderRepository.save(order);

    }


    @Override
    public OrderDTO getOrderById(UUID id) {
        return OrderMapper.INSTANCE.orderMapper(orderRepository.findById(id).get());
    }
    @Override
    public List<OrderDTO> getOrders() {
        List<Order> orders=orderRepository.findAll();
        return orders.stream().map(OrderMapper.INSTANCE::orderMapper).collect(Collectors.toList());
    }

    @Override
    public void updateOrderItem(CartItemDTO cartItemDTO) {

    }

    @Override
    public void deleteOrderItem(UUID id) {
        cartItemRepository.deleteById(id);
    }
}
