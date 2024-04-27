package org.mgb.orderservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mgb.orderservice.model.Product;

import java.util.UUID;


@Data @RequiredArgsConstructor
public class CartItemDTO{
    private UUID id;
    private Product product;
    private int quantity;

}
