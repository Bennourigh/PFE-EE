package org.mgb.orderservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mgb.orderservice.DTOs.CartItemDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.entities.CartItem;
import org.mgb.orderservice.entities.Order;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDTO orderMapper(Order order);
    Order orderMapper(OrderDTO orderDTO);
    CartItem orderMapper(CartItemDTO cartItemDTO);

    CartItemDTO orderMapper(CartItem cartItem);

}
