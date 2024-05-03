package org.mgb.orderservice.DTOs;


import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.mgb.orderservice.entities.CartItem;
import org.mgb.orderservice.enums.OrderStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Data @RequiredArgsConstructor

public class OrderDTO {
    private UUID orderId;
    private Date createdAt;
    private OrderStatus status;
    private double totalPrice;
    private ClientDTO client;
}
