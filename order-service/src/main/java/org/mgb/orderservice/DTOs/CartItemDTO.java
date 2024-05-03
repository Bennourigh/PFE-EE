package org.mgb.orderservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mgb.orderservice.model.Product;

import java.util.UUID;


@Data @RequiredArgsConstructor
public class CartItemDTO{
    private UUID id;
    private UUID productId;
    private String name;
    private double price;
    private int quantity;

}
